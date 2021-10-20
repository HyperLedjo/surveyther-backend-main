package com.hyperledjo.surveyther.DTO;

public class TransferComments {
	private int surveyId;
	private int comments;

	@Override
	public String toString() {
		return "TransferComments [surveyId=" + surveyId + ", comments=" + comments + "]";
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}
}
