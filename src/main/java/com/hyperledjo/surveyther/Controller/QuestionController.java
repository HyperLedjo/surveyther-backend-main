package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Question;
import com.hyperledjo.surveyther.Service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
