package com.hyperledjo.surveyther.DTO;

public class TransferLikes {
	private int surveyId;
	private int likes;

	@Override
	public String toString() {
		return "TransferLikes [surveyId=" + surveyId + ", likes=" + likes + "]";
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}
