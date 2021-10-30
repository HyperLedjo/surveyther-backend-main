package com.hyperledjo.surveyther.Controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.Blockchain.Web3Contract;
import com.hyperledjo.surveyther.DTO.Category;
import com.hyperledjo.surveyther.DTO.Survey;
import com.hyperledjo.surveyther.Service.CategoryService;
import com.hyperledjo.surveyther.Service.SurveyService;

@RestController
@RequestMapping("/api")
public class SurveyController {

	private SurveyService surveyService;
	private CategoryService categoryService;
	private Web3Contract web3Contract;

	public SurveyController(SurveyService surveyService, CategoryService categoryService, Web3Contract web3Contract) {
		this.surveyService = surveyService;
		this.categoryService = categoryService;
		this.web3Contract = web3Contract;
	}

	@PostMapping("/survey")
	public int postSurvey(@RequestBody Survey survey) {
		int no = surveyService.postSurvey(survey);
		String now = LocalDate.now().toString();

		try {
			Map<String, String> map = web3Contract.regSurveyStore(BigInteger.valueOf(survey.getMemberId()), BigInteger.valueOf(no), now);
			int blockNo = Integer.valueOf(map.get("blockNum"));
			survey.setBlockNo(blockNo);
			survey.setTxHash(map.get("txHash"));
			
			int result = surveyService.patchSurvey(survey);
			if(result < 1) {
				return -1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no;
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
	public int getMySurvey(@PathVariable("id") int id) {
		return surveyService.getMySurvey(id);
	}

	@GetMapping("/surveys/my/{id}")
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
