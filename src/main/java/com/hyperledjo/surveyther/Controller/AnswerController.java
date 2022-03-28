package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Answer;
import com.hyperledjo.surveyther.Service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AnswerController {
	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@PostMapping("/answers") 
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
	
	@GetMapping("/answers/{id}")
	public List<Answer> getAnswersFromSurvey(@PathVariable("id") int id) {
		return answerService.getAnswersFromSurvey(id);
	}
	
	@GetMapping("/answer/{id}")
	public Map<String, String> getAnswer(@PathVariable("id") int id) {
		return answerService.getAnswer(id);
	}
	
	@GetMapping("/answers")
	public List<Answer> getAnswerList() {
		return answerService.getAnswerList();
	}
}
