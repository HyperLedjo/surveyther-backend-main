package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.SurveyDAO;
import com.hyperledjo.surveyther.DTO.Survey;
import com.hyperledjo.surveyther.DTO.TransferComments;
import com.hyperledjo.surveyther.DTO.TransferLikes;

@Service
public class SurveyService {

	private SurveyDAO surveyDAO;

	public SurveyService(SurveyDAO surveyDAO) {
		this.surveyDAO = surveyDAO;
	}
	
	public int updateComments(TransferComments tc) {
		return surveyDAO.updateComments(tc);
	}
	
	public int updateLikes(TransferLikes tl) {
		return surveyDAO.updateLikes(tl);
	}
	
	public int postSurvey(Survey survey) {
		return surveyDAO.postSurvey(survey);
	}
	
	public Survey closeSurvey(int id) {
		int result = surveyDAO.closeSurvey(id);
		Survey survey = null;
		if(0 < result) {
			survey = surveyDAO.getSurvey(id);
		}
		return survey;
	}
	
	public List<Survey> getClosedSurveyList() {
		return surveyDAO.getClosedSurveyList();
	}
	
	public List<Survey> getOnGoingSurveyList() {
		return surveyDAO.getOnGoingSurveyList();
	}
	
	public List<Survey> getMySurveyList(int id) {
		return surveyDAO.getMySurveyList(id);
	}
	
	public List<Survey> getCategorySurveyList(int id) {
		return surveyDAO.getCategorySurveyList(id);
	}
	
	public Survey getSurvey(int id) {
		return surveyDAO.getSurvey(id);
	}
	
	public List<Survey> getSurveyList() {
		return surveyDAO.getSurveyList();
	}
}
