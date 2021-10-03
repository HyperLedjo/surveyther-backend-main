package com.hyperledjo.surveyther.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.Service.ChoiceService;

@RestController
@RequestMapping("/api")
public class ChoiceController {
	private ChoiceService choiceService;

	public ChoiceController(ChoiceService choiceService) {
		this.choiceService = choiceService;
	}
}
