package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.MemberDAO;
import com.hyperledjo.surveyther.DTO.Member;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return memberDAO.getMemberList();
	}

	@Override
	public void postMember(Member member) {
		// TODO Auto-generated method stub
		memberDAO.postMember(member);
	}

}
