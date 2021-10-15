package com.hyperledjo.surveyther.DTO;

public class Reward {
	private int no;
	private int surveyId;
	private double reward1;
	private double reward2;
	private boolean status;

	@Override
	public String toString() {
		return "Reward [no=" + no + ", surveyId=" + surveyId + ", reward1=" + reward1 + ", reward2=" + reward2
				+ ", status=" + status + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public double getReward1() {
		return reward1;
	}

	public void setReward1(double reward1) {
		this.reward1 = reward1;
	}

	public double getReward2() {
		return reward2;
	}

	public void setReward2(double reward2) {
		this.reward2 = reward2;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
