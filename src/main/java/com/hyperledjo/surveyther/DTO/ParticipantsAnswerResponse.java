package com.hyperledjo.surveyther.DTO;

public class ParticipantsAnswerResponse {
//	private int surveyId;
	private int questionId;
	private int answerId;
	private int result;

	@Override
	public String toString() {
		return "ParticipantsAnswerResponse [questionId=" + questionId + ", answerId=" + answerId + ", result=" + result
				+ "]";
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
