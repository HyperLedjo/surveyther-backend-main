package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Participants;
import com.hyperledjo.surveyther.Service.ParticipantsService;

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
			return -1;
		return result;
	}

	@GetMapping("/participants/{id}")
	public List<Participants> getParticipantsList(@PathVariable("id") int id) {
		return participantsService.getParticipantsList(id);
	}
}
