package com.hyperledjo.surveyther.DTO;

public class Answer {
	private int no;
	private int choiceId;
	private String content;

	@Override
	public String toString() {
		return "Answer [no=" + no + ", choiceId=" + choiceId + ", content=" + content + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(int choiceId) {
		this.choiceId = choiceId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
