package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.ParticipantsDAO;
import com.hyperledjo.surveyther.DTO.Participants;

@Service
public class ParticipantsService {
	private ParticipantsDAO participantsDAO;
	
	public ParticipantsService(ParticipantsDAO participantsDAO) {
		// TODO Auto-generated constructor stub
		this.participantsDAO = participantsDAO;
	}
	
	public int postParticipants(List<Participants> participants) {
//		return participantsDAO.postParticipants(participants);
		if(participants.isEmpty()) return -1;
		for(Participants p : participants) {
			if(p == null) return 0;
			participantsDAO.postParticipants(p);
		}
		return 1;
	}
	
	// id is participants entitiy's id of survey(fk)
	public List<Participants> getParticipantsList(int id) {
		return participantsDAO.getParticipantsList(id);
	}
}
