package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.MemberDAO;
import com.hyperledjo.surveyther.DTO.Member;

@Service
public class MemberService {

	private MemberDAO memberDAO;

	public MemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public int putMember(Member member) {
		return memberDAO.putMember(member);
	}
	
	public Member getMember(String id) {
		return memberDAO.getMember(id);
	}
	
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return memberDAO.getMemberList();
	}

	public void postMember(Member member) {
		// TODO Auto-generated method stub
		memberDAO.postMember(member);
	}

}
