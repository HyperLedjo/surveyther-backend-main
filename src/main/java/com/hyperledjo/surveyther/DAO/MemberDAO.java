package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Member;

@Repository
public class MemberDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.MemberDAO";
	private SqlSessionTemplate sql;

	public MemberDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	public void postMember(Member member) {
		sql.insert(nameSpace + ".postMember", member);
	}
	
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		List<Member> memberList = sql.selectList(nameSpace + ".getMemberList");
		return memberList;
	}

}
