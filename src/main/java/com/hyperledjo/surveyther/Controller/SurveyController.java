package com.hyperledjo.surveyther.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Category;
import com.hyperledjo.surveyther.Service.SurveyService;

@RestController
@RequestMapping("/api")
public class SurveyController {

	private SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@PostMapping("/test")
	public int testOnSpring(@RequestBody Category c) {
		return surveyService.testOnSpring(c); 
	}

}
