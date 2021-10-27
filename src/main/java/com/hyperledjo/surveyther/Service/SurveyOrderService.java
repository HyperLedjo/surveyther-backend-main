package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.SurveyOrderDAO;
import com.hyperledjo.surveyther.DTO.SurveyOrder;

@Service
public class SurveyOrderService {
	private SurveyOrderDAO surveyOrderDAO;
	
	public SurveyOrderService(SurveyOrderDAO surveyOrderDAO) {
		// TODO Auto-generated constructor stub
		this.surveyOrderDAO = surveyOrderDAO;
	}

	public int postSurveyOrder(SurveyOrder surveyOrder) {
		return surveyOrderDAO.postSurveyOrder(surveyOrder);
	}
}
