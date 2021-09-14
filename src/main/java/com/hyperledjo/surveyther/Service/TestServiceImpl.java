package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.TestDAO;
import com.hyperledjo.surveyther.DTO.TestDTO;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAO testDAO;
	
	public List<TestDTO> selectTestList() {
		return testDAO.selectTestList();
	}
	
}
