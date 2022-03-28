package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.DTO.Reward;
import com.hyperledjo.surveyther.Service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
