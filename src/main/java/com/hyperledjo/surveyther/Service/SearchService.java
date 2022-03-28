package com.hyperledjo.surveyther.Service;

import com.hyperledjo.surveyther.DAO.SearchDAO;
import com.hyperledjo.surveyther.DTO.Survey;
import org.springframework.stereotype.Service;

import java.util.List;

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
