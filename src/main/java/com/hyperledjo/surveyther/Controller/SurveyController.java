package com.hyperledjo.surveyther.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.Service.SurveyService;

@RestController
@RequestMapping("/api")
public class SurveyController {

	private SurveyService surveySerivce;

	public SurveyController(SurveyService surveyService) {
		this.surveySerivce = surveyService;
	}
}
