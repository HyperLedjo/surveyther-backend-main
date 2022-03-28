package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Answer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.AnswerDAO";
	private SqlSessionTemplate sql;

	public AnswerDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	public int postAnswer(Answer answer) {
		try {
			sql.insert(nameSpace + ".postAnswer", answer);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public List<Answer> getAnswersFromSurvey(int id) {
		return sql.selectList(nameSpace + ".getAnswersFromSurvey", id);
	}

	public String getAnswer(int id) {
		return sql.selectOne(nameSpace + ".getAnswer", id);
	}

	public List<Answer> getAnswerList() {
		return sql.selectList(nameSpace + ".getAnswerList");
	}

}
