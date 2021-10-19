package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.SearchDAO;
import com.hyperledjo.surveyther.DTO.Survey;

@Service
public class SearchService {

	private SearchDAO searchDAO;
	
	public SearchService(SearchDAO searchDAO) {
		// TODO Auto-generated constructor stub
		this.searchDAO = searchDAO;
	}
	
	public List<Survey> searchSurvey(String keyword) {
		return searchDAO.searchSurvey(keyword);
	}
}
