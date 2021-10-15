package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.RewardDAO;
import com.hyperledjo.surveyther.DTO.Reward;

@Service
public class RewardService {
	
	private RewardDAO rewardDAO;
	
	public RewardService(RewardDAO rewardDAO) {
		// TODO Auto-generated constructor stub
		this.rewardDAO = rewardDAO;
	}
	
	public int closeReward(int id) {
		return rewardDAO.closeReward(id);
	}
	
	public int postReward(Reward reward) {
		return rewardDAO.postReward(reward);
	}
	
	public List<Reward> getRewardList(int id) {
		return rewardDAO.getRewardList(id);
	}
}
