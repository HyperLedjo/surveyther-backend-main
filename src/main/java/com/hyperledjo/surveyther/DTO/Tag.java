package com.hyperledjo.surveyther.DTO;

public class Tag {
	private int no;
	private int surveyId;
	private String content;

	@Override
	public String toString() {
		return "Tag [no=" + no + ", surveyId=" + surveyId + ", content=" + content + "]";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
