package com.hyperledjo.surveyther.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperledjo.surveyther.DAO.ParticipantsDAO;
import com.hyperledjo.surveyther.DTO.Participants;
import com.hyperledjo.surveyther.DTO.ParticipantsAnswerResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

	public JsonNode getParticipantsSurveyResponseInfo(int id) {
		List<Participants> getParticipantsQuestionIdsInfo = participantsDAO.getParticipantsQuestionIdsInfo(id);
		List<ParticipantsAnswerResponse> answerResponses = new ArrayList<>();
		ObjectMapper objMapper = new ObjectMapper();

		
		getParticipantsQuestionIdsInfo.forEach(data -> {
			List<Participants> getParticipantsAnswerIdsInfo = participantsDAO
					.getParicipantsAnswerIdsInfo(data.getQuestionId());
			getParticipantsAnswerIdsInfo.forEach(answer -> {
				ParticipantsAnswerResponse answerResponse = new ParticipantsAnswerResponse();
//				answerResponse.setSurveyId(id);
				answerResponse.setQuestionId(data.getQuestionId());
				answerResponse.setAnswerId(answer.getAnswerId());
				answerResponse.setResult(participantsDAO.getParticipantsAnswersCount(answer.getAnswerId()));
				answerResponses.add(answerResponse);
			});
		});

		JsonNode jsonNode = objMapper.valueToTree(answerResponses);
		return jsonNode;
	}

	public int getParticipantsMembersCount(int id) {
		return participantsDAO.getParticipantsMembersCount(id);
	}

	// id is participants entitiy's id of survey(fk)
//	public List<Participants> getParticipantsList(int id) {
//		return participantsDAO.getParticipantsList(id);
//	}
}
