package com.hyperledjo.surveyther.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.SurveyOrder;

@Repository
public class SurveyOrderDAO {
	private String nameSpace = "com.hyperledjo.surveyther.DAO.SurveyOrderDAO";
	private SqlSessionTemplate sql;
	
	public SurveyOrderDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}
	
	// 서베이 주문 내역 등록
	public int postSurveyOrder(SurveyOrder surveyOrder) {
		return sql.insert(nameSpace + ".postSurveyOrder", surveyOrder);
	}
}
