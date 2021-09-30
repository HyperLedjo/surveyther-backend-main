package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.SurveyDAO;
import com.hyperledjo.surveyther.DTO.Category;

@Service
public class SurveyService {

	private SurveyDAO surveyDAO;

	public SurveyService(SurveyDAO surveyDAO) {
		this.surveyDAO = surveyDAO;
	}

	public int testOnSpring(Category c) {
		return surveyDAO.testOnSpring(c);
	}
}
