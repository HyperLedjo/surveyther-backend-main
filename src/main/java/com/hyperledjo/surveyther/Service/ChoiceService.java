package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.ChoiceDAO;
import com.hyperledjo.surveyther.DTO.Choice;

@Service
public class ChoiceService {

	private ChoiceDAO choiceDAO;
	
	public ChoiceService(ChoiceDAO choiceDAO) {
		this.choiceDAO = choiceDAO;
	}
	
	public int postChoice(Choice choice) {
		return choiceDAO.postChoice(choice);
	}
	
	public List<Choice> getChoicesFromSurvey(int id) {
		return choiceDAO.getChoicesFromSurvey(id);
	}
	
	public List<Choice> getChoiceList() {
		return choiceDAO.getChoiceList();
	}
}
