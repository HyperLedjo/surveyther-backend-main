package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Member;
import com.hyperledjo.surveyther.Service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PatchMapping("/member")
	public int patchMember(@RequestBody Member member) {
		return memberService.patchMember(member);
	}
	
	@PostMapping("/member")
	public int postMember(@RequestBody Member member) {
		return memberService.postMember(member);
	}
	
	/*
	 * 
	 */
	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable("id") String id) {
		return memberService.getMember(id);
	}

	/*
	 * 회원 목록 조회 서비스 GET 방식으로 DB에 저장된 모든 회원 정보를 조회 return List<Member>
	 */
	@GetMapping("/member")
	public List<Member> getMemberList() {
		List<Member> memberList = memberService.getMemberList();
		System.out.println(memberList);
		return memberList;
	}
}
