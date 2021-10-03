package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Question;
import com.hyperledjo.surveyther.Service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("/question")
	public List<Question> getQuestionList() {
		return null;
	}
}
