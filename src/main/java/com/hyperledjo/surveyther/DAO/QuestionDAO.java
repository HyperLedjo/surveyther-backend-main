package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Question;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.QuestionDAO";
	private SqlSessionTemplate sql;
	
	public QuestionDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	public int postQuestion(Question question) {
		try { 
			sql.insert(nameSpace + ".postQuestion", question);	
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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
