package com.hyperledjo.surveyther.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.Service.AnswerService;

@RestController
@RequestMapping("/api")
public class AnswerController {
	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
}
