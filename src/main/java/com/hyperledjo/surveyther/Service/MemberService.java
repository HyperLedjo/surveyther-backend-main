package com.hyperledjo.surveyther.Service;

import java.util.List;

import com.hyperledjo.surveyther.DTO.TestDTO;

public interface TestService {

	List<TestDTO> selectTestList();
	
}
