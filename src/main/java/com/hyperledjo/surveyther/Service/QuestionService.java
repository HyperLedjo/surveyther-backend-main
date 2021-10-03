package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.QuestionDAO;

@Service
public class QuestionService {

	private QuestionDAO questionDAO;

	public QuestionService(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
}
