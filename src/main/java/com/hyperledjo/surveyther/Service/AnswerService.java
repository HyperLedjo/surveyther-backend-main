package com.hyperledjo.surveyther.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperledjo.surveyther.DAO.AnswerDAO;
import com.hyperledjo.surveyther.DTO.Answer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getAnswer(int id) {
		String result = answerDAO.getAnswer(id);
		String json = "{\"content\":\""
						+ result + "\""
						+ "}";
		ObjectMapper objMapper = new ObjectMapper();
		Map<String, String> map; 
		try {
			map = objMapper.readValue(json, Map.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return map;
	}
	
	public List<Answer> getAnswerList() {
		return answerDAO.getAnswerList();
	}
}
