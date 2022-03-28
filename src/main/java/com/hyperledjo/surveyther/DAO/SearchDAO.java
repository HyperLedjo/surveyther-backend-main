package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Survey;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
