package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.AnswerDAO;
import com.hyperledjo.surveyther.DTO.Answer;

@Service
public class AnswerService {

	private AnswerDAO answerDAO;

	public AnswerService(AnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}
	
	public int postAnswer(Answer answer) {
		return answerDAO.postAnswer(answer);
	}
	
	public List<Answer> getAnswersFromSurvey(int id) {
		return answerDAO.getAnswersFromSurvey(id);
	}
	
	public List<Answer> getAnswerList() {
		return answerDAO.getAnswerList();
	}
}
