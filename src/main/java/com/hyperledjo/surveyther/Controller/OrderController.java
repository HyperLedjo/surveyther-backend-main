package com.hyperledjo.surveyther.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.SurveyOrder;
import com.hyperledjo.surveyther.Service.SurveyOrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	private SurveyOrderService surveyOrderService;
	
	public OrderController(SurveyOrderService surveyOrderService) {
		// TODO Auto-generated constructor stub
		this.surveyOrderService = surveyOrderService;
	}
	
	@PostMapping("/order/survey/check")
	public SurveyOrder checkSurveyOrder(@RequestBody SurveyOrder surveyOrder) {
		return surveyOrderService.checkSurveyOrder(surveyOrder);
	}
	
	@PostMapping("/order/survey")
	public int postSurveyOrder(@RequestBody SurveyOrder surveyOrder) {
		return surveyOrderService.postSurveyOrder(surveyOrder);
	}
}
