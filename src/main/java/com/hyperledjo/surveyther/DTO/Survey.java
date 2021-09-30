package com.hyperledjo.surveyther.DTO;

import java.sql.Date;
import java.sql.Timestamp;

public class Survey {
	private int no;
	private int memberId;
	private int category;
	private String title;
	private String content;
	private int goalParticipants;
	private Timestamp regDate;
	private Date deadline;
	// status - 0: 진행, 1: 마감
	private int status;

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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getGoalParticipants() {
		return goalParticipants;
	}

	public void setGoalParticipants(int goalParticipants) {
		this.goalParticipants = goalParticipants;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Survey [no=" + no + ", memberId=" + memberId + ", category=" + category + ", title=" + title
				+ ", content=" + content + ", goalParticipants=" + goalParticipants + ", regDate=" + regDate
				+ ", deadline=" + deadline + ", status=" + status + "]";
	}
}
