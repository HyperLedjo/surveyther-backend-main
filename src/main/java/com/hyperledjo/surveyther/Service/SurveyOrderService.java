package com.hyperledjo.surveyther.Service;

import com.hyperledjo.surveyther.DAO.SurveyOrderDAO;
import com.hyperledjo.surveyther.DTO.SurveyOrder;
import org.springframework.stereotype.Service;

@Service
public class SurveyOrderService {
	private SurveyOrderDAO surveyOrderDAO;
	
	public SurveyOrderService(SurveyOrderDAO surveyOrderDAO) {
		// TODO Auto-generated constructor stub
		this.surveyOrderDAO = surveyOrderDAO;
	}

	public SurveyOrder checkSurveyOrder(SurveyOrder surveyOrder) {
		return surveyOrderDAO.checkSurveyOrder(surveyOrder);
	}
	
	public int postSurveyOrder(SurveyOrder surveyOrder) {
		return surveyOrderDAO.postSurveyOrder(surveyOrder);
	}
}
