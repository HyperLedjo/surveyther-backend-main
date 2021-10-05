package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.QuestionDAO;
import com.hyperledjo.surveyther.DTO.Question;

@Service
public class QuestionService {

	private QuestionDAO questionDAO;

	public QuestionService(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	
	public int postQuestion(Question question) {
		return questionDAO.postQuestion(question);
	}
	
	public List<Question> getQuestionsFromSurvey(int id) {
		return questionDAO.getQuestionFromSurvey(id);
	}
	
	public List<Question> getQuestionList() {
		return questionDAO.getQuestionList();
	}
}
