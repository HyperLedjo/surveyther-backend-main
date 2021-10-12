package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/question")
	public List<Question> postQuestion(@RequestBody List<Question> questions) {
		
		if(questions.isEmpty()) return null;
		
		for(Question question : questions) {
			questionService.postQuestion(question);
		}
		return questions;
	}
	
//	@PostMapping("/question")
//	public int postQuestion(@RequestBody Question question) {
//		return questionService.postQuestion(question);
//	}
	
	@GetMapping("/question/{id}")
	public List<Question> getQuestionsFromSurvey(@PathVariable("id") int id) {
		return questionService.getQuestionsFromSurvey(id);
	}
	
	@GetMapping("/question")
	public List<Question> getQuestionList() {
		return questionService.getQuestionList();
	}
}
