package com.hyperledjo.surveyther.DTO;

import java.sql.Timestamp;

public class Participants {
	private int no;
	private int memberId;
	private int surveyId;
	private int questionId;
	private int answerId;
	private Timestamp participation;

	@Override
	public String toString() {
		return "Participants [no=" + no + ", memberId=" + memberId + ", surveyId=" + surveyId + ", questionId="
				+ questionId + ", answerId=" + answerId + ", participation=" + participation + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
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

	public Timestamp getParticipation() {
		return participation;
	}

	public void setParticipation(Timestamp participation) {
		this.participation = participation;
	}
}
