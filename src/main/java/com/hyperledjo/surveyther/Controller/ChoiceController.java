package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Choice;
import com.hyperledjo.surveyther.Service.ChoiceService;

@RestController
@RequestMapping("/api")
public class ChoiceController {
	private ChoiceService choiceService;

	public ChoiceController(ChoiceService choiceService) {
		this.choiceService = choiceService;
	}
	
	@PostMapping("/choice")
	public int postChoice(@RequestBody Choice choice) {
		return choiceService.postChoice(choice);
	}
	
	@GetMapping("/choice/{id}")
	public List<Choice> getChoicesFromSurvey(@PathVariable("id") int id) {
		return choiceService.getChoicesFromSurvey(id);
	}
	
	@GetMapping("/choice")
	public List<Choice> getChoiceList() {
		return choiceService.getChoiceList();
	}
}
