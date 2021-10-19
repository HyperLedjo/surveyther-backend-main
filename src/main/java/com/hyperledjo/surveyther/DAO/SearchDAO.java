package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Survey;

@Repository
public class SearchDAO {
	
	private String nameSpace = "com.hyperledjo.surveyther.DAO.SearchDAO";
	private SqlSessionTemplate sql;
	
	public SearchDAO(SqlSessionTemplate sql) {
		// TODO Auto-generated constructor stub
		this.sql = sql;
	}
	
	public List<Survey> searchSurvey(String keyword) {
		return sql.selectList(nameSpace + ".searchSurvey", keyword);
	}
}
