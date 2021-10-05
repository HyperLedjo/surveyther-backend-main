package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Answer;

@Repository
public class AnswerDAO {

	private String nameSpace = "com.hyperledjo.surveyther.AnswerDAO";
	private SqlSessionTemplate sql;
	
	public AnswerDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public int postAnswer(Answer answer) {
		try { 
			sql.insert(nameSpace + ".postMember", answer);	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			System.out.println("[POST]" + answer.toString());
		}
		return 1;
	}
	
	public List<Answer> getAnswersFromSurvey(int id) {
		return sql.selectList(nameSpace + ".getAnswersFromSurvey", id);
	}
	
	public List<Answer> getAnswerList() {
		return sql.selectList(nameSpace + ".getAnswerList");
	}
	
}