package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.AnswerDAO;

@Service
public class AnswerService {

	private AnswerDAO answerDAO;

	public AnswerService(AnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}
}
