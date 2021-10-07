package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Survey;
import com.hyperledjo.surveyther.Service.SurveyService;

@RestController
@RequestMapping("/api")
public class SurveyController {

	private SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}
	
	@PostMapping("/survey")
	public int postSurvey(@RequestBody Survey survey) {
		return surveyService.postSurvey(survey);
	}
	
	@PatchMapping("/survey/{id}")
	public Survey closeSurvey(@PathVariable("id") int id) {
		return surveyService.closeSurvey(id);
	}
	
	@GetMapping("/survey/closed")
	public List<Survey> getClosedSurveyList() {
		return surveyService.getClosedSurveyList();
	}
	
	@GetMapping("/survey/ongoing")
	public List<Survey> getOnGoinSurveyList() {
		return surveyService.getOnGoingSurveyList();
	}
	
	@GetMapping("/survey/my/{id}")
	public List<Survey> getMySurveyList(@PathVariable("id") int id) {
		return surveyService.getMySurveyList(id);
	}
	
	@GetMapping("/survey/{id}")
	public Survey getSurvey(@PathVariable("id") int id) {
		return surveyService.getSurvey(id);
	}
	
	@GetMapping("/survey")
	public List<Survey> getSurveyList() {
		return surveyService.getSurveyList();
	}
}
