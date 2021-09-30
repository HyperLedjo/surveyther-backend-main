package com.hyperledjo.surveyther.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Category;

@Repository
public class SurveyDAO {
	private String nameSpace = "com.hyperledjo.surveyther.DAO.SurveyDAO";
	private SqlSessionTemplate sql;

	public SurveyDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

	public int testOnSpring(Category c) {
		int check = sql.insert(nameSpace + ".insertTest", c);
		System.out.println(check);
		System.out.println(c.getNo());
		return check;
	}
}
