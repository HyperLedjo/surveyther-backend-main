package com.hyperledjo.surveyther.DTO;

public class Answer {
	private int no;
	private int questionId;
	private String content;

	@Override
	public String toString() {
		return "Answer [no=" + no + ", questionId=" + questionId + ", content=" + content + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
