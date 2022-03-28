package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Survey;
import com.hyperledjo.surveyther.Service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

	private SearchService searchService;
	
	 public SearchController(SearchService searchService) {
		// TODO Auto-generated constructor stub
		 this.searchService = searchService;
	}
	 
	 @GetMapping("/search")
	 public List<Survey> searchSurvey(@RequestParam(name="keyword") String keyword) {
		 return searchService.searchSurvey(keyword);
	 }
	
}
