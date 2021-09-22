package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.TestDTO;
import com.hyperledjo.surveyther.Service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping("/test")
	public List<TestDTO> test() {
		System.out.println("Run Test");
		List<TestDTO> testList = testService.selectTestList();
		System.out.println(testList);
		return testList;
	}
}
