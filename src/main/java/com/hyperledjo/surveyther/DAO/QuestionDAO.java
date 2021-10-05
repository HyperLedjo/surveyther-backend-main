package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Question;

@Repository
public class QuestionDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.QuestionDAO";
	private SqlSessionTemplate sql;
	
	public QuestionDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public int postQuestion(Question question) {
		try { 
			sql.insert(nameSpace + ".postMember", question);	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			System.out.println("[POST]" + question.toString());
		}
		return question.getNo();
	}
	
	public List<Question> getQuestionFromSurvey(int id) {
		return sql.selectList(nameSpace + ".getQuestionsFromSurvey", id);
	}
	
	public List<Question> getQuestionList() {
		return sql.selectList(nameSpace + ".getQuestionList");
	}
}
