package com.hyperledjo.surveyther.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyDAO {
	private String nameSpace = "com.hyperledjo.surveyther.DAO.SurveyDAO";
	private SqlSessionTemplate sql;

	public SurveyDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
}
