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

	public int uploadWallet(Member member) {
		return sql.update(nameSpace + ".uploadWallet", member);
	}
	
	public int patchMember(Member member) {
		int result = sql.update(nameSpace + ".patchMember", member);
		if (result < 1) {
			return 0;
		}
		return 1;
	}

	public int postMember(Member member) {
		try {
			sql.insert(nameSpace + ".postMember", member);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public Member getMember(String id) {
		return sql.selectOne(nameSpace + ".getMember", id);
	}

	public List<Member> getMemberList() {
		List<Member> memberList = sql.selectList(nameSpace + ".getMemberList");
		return memberList;
	}
}
