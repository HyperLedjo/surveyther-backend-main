package com.hyperledjo.surveyther.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.hyperledjo.surveyther.DTO.Participants;
import com.hyperledjo.surveyther.Service.ParticipantsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParticipantsController {

	private ParticipantsService participantsService;

	public ParticipantsController(ParticipantsService participantsService) {
		// TODO Auto-generated constructor stub
		this.participantsService = participantsService;
	}

	@PostMapping("/participants")
	public int postParticipants(@RequestBody List<Participants> participants) {
		int result = participantsService.postParticipants(participants);
		if (result < 1)
			return result;
		return result;
	}
	
	// 한 서베이에 응답된 답변수 집계
	@GetMapping("/participants/survey/{id}")
	public JsonNode getParicipantsSurveyResponseInfo(@PathVariable("id") int id) {
		return participantsService.getParticipantsSurveyResponseInfo(id);
	}
	
	// 한 서베이에 참여한 인원수 집계
	@GetMapping("/participants/members/{id}")
	public int getParticipantsMembersCount(@PathVariable("id") int id) {
		return (Integer) participantsService.getParticipantsMembersCount(id);
	}
	
	// 각 질문에 해당하는 답변 집계(어떻게 한번에 질의할 수 있을까?)
	
	// 한 서베이에 참여한 참여(Participants) 객체 집계
//	@GetMapping("/participants/{id}")
//	public List<Participants> getParticipantsList(@PathVariable("id") int id) {
//		return participantsService.getParticipantsList(id);
//	}
}
