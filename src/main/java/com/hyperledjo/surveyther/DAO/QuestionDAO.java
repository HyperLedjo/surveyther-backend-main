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
		int result = sql.insert(nameSpace + ".postQuestion", question);
		if(0 < result) { 
			return question.getNo();
		}
		return result;
	}
	
	public List<Question> getQuestionFromSurvey(int id) {
		return sql.selectList(nameSpace + ".getQuestionsFromSurvey", id);
	}
	
	public List<Question> getQuestionList() {
		return sql.selectList(nameSpace + ".getQuestionList");
	}
}
