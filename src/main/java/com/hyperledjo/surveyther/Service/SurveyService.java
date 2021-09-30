package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.SurveyDAO;

@Service
public class SurveyService {

	private SurveyDAO surveyDAO;
	
	public SurveyService(SurveyDAO surveyDAO) {
		this.surveyDAO = surveyDAO;
	}
}
