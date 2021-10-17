package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.Survey;

@Repository
public class SurveyDAO {
	private String nameSpace = "com.hyperledjo.surveyther.DAO.SurveyDAO";
	private SqlSessionTemplate sql;

	public SurveyDAO(SqlSessionTemplate sql) {
		this.sql = sql;
	}

//	public List<Survey> searchSurvey(String search) {
//		
//	}

	public List<Survey> getSurveyToCloseList(String now) {
		return sql.selectList(nameSpace + ".getSurveyToCloseList", now);
	}
	
	public int postSurvey(Survey survey) {
		try {
			sql.insert(nameSpace + ".postSurvey", survey);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return survey.getNo();
	}

	public int closeSurvey(int id) { 
		return sql.update(nameSpace + ".closeSurvey", id);
	}

	// status가 1인 서베이 목록 조회
	public List<Survey> getClosedSurveyList() {
		return sql.selectList(nameSpace + ".getClosedSurveyList");
	}

	// status가 0인 서베이 목록 조회
	public List<Survey> getOnGoingSurveyList() {
		return sql.selectList(nameSpace + ".getOnGoingSurveyList");
	}

	public List<Survey> getMySurveyList(int id) {
		return sql.selectList(nameSpace + ".getMySurveyList", id);
	}

	public List<Survey> getCategorySurveyList(int id) {
		return sql.selectList(nameSpace + ".getCategorySurveyList", id);
	}
	
	public Survey getSurvey(int id) {
		return sql.selectOne(nameSpace + ".getSurvey", id);
	}

	public List<Survey> getSurveyList() {
		return sql.selectList(nameSpace + ".getSurveyList");
	}
}
