package com.hyperledjo.surveyther.DAO;

import com.hyperledjo.surveyther.DTO.Reward;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RewardDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.RewardDAO";
	private SqlSessionTemplate sql;

	public RewardDAO(SqlSessionTemplate sql) {
		// TODO Auto-generated constructor stub
		this.sql = sql;
	}

	public int closeReward(int id) {
		return sql.update(nameSpace + ".closeReward", id);
	}

	public int postReward(Reward reward) {
		return sql.insert(nameSpace + ".postReward", reward);
	}

	public List<Reward> getRewardList(int id) {
		return sql.selectList(nameSpace + ".getRewardList", id);
	}
}
