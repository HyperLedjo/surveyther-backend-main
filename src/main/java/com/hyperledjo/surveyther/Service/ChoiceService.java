package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.ChoiceDAO;

@Service
public class ChoiceService {

	private ChoiceDAO choiceDAO;
	
	public ChoiceService(ChoiceDAO choiceDAO) {
		this.choiceDAO = choiceDAO;
	}
}
