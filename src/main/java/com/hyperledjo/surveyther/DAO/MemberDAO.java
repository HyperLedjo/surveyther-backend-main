package com.hyperledjo.surveyther.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hyperledjo.surveyther.DTO.TestDTO;

@Repository
public class TestDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.TestDAO";
	
	@Autowired
	private SqlSessionTemplate sql;
	
	
	public List<TestDTO> selectTestList() {
		// TODO Auto-generated method stub
		List<TestDTO> testList = sql.selectList(nameSpace + ".selectTestList");
		return testList;
	}

}
