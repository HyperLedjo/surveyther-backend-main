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
		// 참여 정보가 없습니다.
		if (participants.isEmpty())
			return -2;

		int size = participants.size();
		int check = participantsDAO.checkParticipants(participants.get(0));

		// 중복 참여 방지
		if (check < size) {
			for (Participants p : participants) {
				if (p == null)
					return -1;
				participantsDAO.postParticipants(p);
			}
		} else {
			return 0;
		}
		return 1;
	}

	public int getParticipantsCount(int id) {
		return participantsDAO.getParticipantsCount(id);
	}

	// id is participants entitiy's id of survey(fk)
//	public List<Participants> getParticipantsList(int id) {
//		return participantsDAO.getParticipantsList(id);
//	}
}
