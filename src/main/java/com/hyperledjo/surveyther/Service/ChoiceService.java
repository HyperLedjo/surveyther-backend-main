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
	
	public List<Choice> getChoiceList() {
		return null;
	}
}
