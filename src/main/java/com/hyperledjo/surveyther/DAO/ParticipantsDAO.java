package com.hyperledjo.surveyther.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Participants;

@Repository
public class ParticipantsDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.ParticipantsDAO";
	private SqlSessionTemplate sql;

	public ParticipantsDAO(SqlSessionTemplate sql) {
		// TODO Auto-generated constructor stub
		this.sql = sql;
	}
	
	public int checkParticipants(Participants participants) {
		return sql.selectOne(nameSpace + ".checkParticipants", participants);
	}
	
	public int postParticipants(Participants participants) {
		return sql.insert(nameSpace + ".postParticipants", participants);
	}
	
	public int getParticipantsCount(int id) {
		return sql.selectOne(nameSpace + ".getParticipantsCount", id);
	}
	
//	public List<Participants> getParticipantsList(int id) {
//		return sql.selectList(nameSpace + ".getParticipantsList", id);
//	}
}
