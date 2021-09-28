package com.hyperledjo.surveyther.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PutMapping("/member")
	public int putMember(HttpSession session, Member member) {
		return memberService.putMember(member);
	}

	/*
	 * 회원 등록 서비스 POST 방식으로 Member Model을 넘겨 DB에 등록
	 */
	@PostMapping("/member")
	public void postMember(Member member) {
		System.out.println(member);
	}

	/*
	 * 회원 단일 조회 입력: 회원 ID 출력: 회원 정보 설명: 하나의 회원 정보만을 불러오기 위해 회원의 ID를 입력받고 해당 정보를
	 * Member 모델에 담아 반환
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
