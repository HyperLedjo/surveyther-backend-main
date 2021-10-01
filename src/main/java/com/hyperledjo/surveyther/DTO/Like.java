package com.hyperledjo.surveyther.DTO;

public class Like {
	private int no;
	private int surveyId;
	private int memberId;
	private boolean liked;

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

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	@Override
	public String toString() {
		return "Like [no=" + no + ", surveyId=" + surveyId + ", memberId=" + memberId + ", liked=" + liked + "]";
	}
}
