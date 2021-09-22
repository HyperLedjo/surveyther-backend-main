package com.hyperledjo.surveyther.Service;

import java.util.List;

import com.hyperledjo.surveyther.DTO.Member;

public interface MemberService {

	public void postMember(Member member);
	public List<Member> getMemberList();
}
