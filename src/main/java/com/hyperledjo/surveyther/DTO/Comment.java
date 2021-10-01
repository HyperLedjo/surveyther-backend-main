package com.hyperledjo.surveyther.DTO;

import java.sql.Timestamp;

public class Comment {
	private int no;
	private int memberId;
	private int surveyId;
	private String content;
	private Timestamp regDate;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Comment [no=" + no + ", memberId=" + memberId + ", surveyId=" + surveyId + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
}
