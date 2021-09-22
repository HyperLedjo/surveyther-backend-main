package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Member;
import com.hyperledjo.surveyther.Service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {

	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping("/member")
	public void postMember(Member member) {
		System.out.println(member);	
	}
	
	@GetMapping("/member")
	public List<Member> getMemberList() {
		List<Member> memberList = memberService.getMemberList();
		System.out.println(memberList);
		return memberList;
	}
}
