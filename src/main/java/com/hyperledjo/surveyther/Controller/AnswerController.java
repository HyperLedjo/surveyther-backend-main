package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Answer;
import com.hyperledjo.surveyther.Service.AnswerService;

@RestController
@RequestMapping("/api")
public class AnswerController {
	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@PostMapping("/answer") 
	public int postAnswer(@RequestBody List<Answer> answers) {
		if(answers.isEmpty()) return -1;
		for(Answer answer : answers) {
			int result = answerService.postAnswer(answer);
			if(result < 1) {
				return 0;
			}
		}
		return 1;
	}
	
	@GetMapping("/answer/{id}")
	public List<Answer> getAnswersFromSurvey(@PathVariable("id") int id) {
		return answerService.getAnswersFromSurvey(id);
	}
	
	@GetMapping("/answer")
	public List<Answer> getAnswerList() {
		return answerService.getAnswerList();
	}
}
