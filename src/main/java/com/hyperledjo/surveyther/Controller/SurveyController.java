package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Answer;
import com.hyperledjo.surveyther.DTO.Category;
import com.hyperledjo.surveyther.DTO.Choice;
import com.hyperledjo.surveyther.DTO.Question;
import com.hyperledjo.surveyther.DTO.Survey;
import com.hyperledjo.surveyther.Service.AnswerService;
import com.hyperledjo.surveyther.Service.CategoryService;
import com.hyperledjo.surveyther.Service.ChoiceService;
import com.hyperledjo.surveyther.Service.QuestionService;
import com.hyperledjo.surveyther.Service.SurveyService;

@RestController
@RequestMapping("/api")
public class SurveyController {

	private SurveyService surveyService;
	private CategoryService categoryService;

	public SurveyController(SurveyService surveyService, CategoryService categoryService) {
		this.surveyService = surveyService;
		this.categoryService = categoryService;
	}

	@PostMapping("/survey")
	public int postSurvey(@RequestBody Survey survey) {
		return surveyService.postSurvey(survey);
	}

	//
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

	@GetMapping("/survey/category/{name}")
	public List<Survey> getCategorySurveyList(@PathVariable("name") String name) {

		List<Category> categories = categoryService.getCategoryList();

		int id = 0;
		for (Category category : categories) {
			if (name.equals(category.getName())) {
				id = category.getNo();
			}
		}

		return surveyService.getCategorySurveyList(id);
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
