package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Reward;
import com.hyperledjo.surveyther.Service.RewardService;

@RestController
@RequestMapping("/api")
public class RewardController {

	private RewardService rewardService;
	
	public RewardController(RewardService rewardService) {
		// TODO Auto-generated constructor stub
		this.rewardService = rewardService;
	}
	
	@PutMapping("/reward/{id}")
	public int closeReward(@PathVariable("id") int id) {
		return rewardService.closeReward(id);
	}
	
	@PostMapping("/reward")
	public int postReward(@RequestBody Reward reward) {
		return rewardService.postReward(reward);
	}
	
	@GetMapping("/reward")
	public List<Reward> getRewardList(@PathVariable("id") int id) {
		return rewardService.getRewardList(id);
	}
}
