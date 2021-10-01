package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.SurveyDAO;
import com.hyperledjo.surveyther.DTO.Survey;

@Service
public class SurveyService {

	private SurveyDAO surveyDAO;

	public SurveyService(SurveyDAO surveyDAO) {
		this.surveyDAO = surveyDAO;
	}

	public Survey getSurvey(int id) {
		return null;
	}
	
	public List<Survey> getSurveyList() {
		return null;
	}
}
