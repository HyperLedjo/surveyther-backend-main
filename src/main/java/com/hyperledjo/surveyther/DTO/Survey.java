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
	private int currentParticipants;
	private Timestamp regDate;
	private Date deadline;
	private double paid;
	private double fee;
	private int likes;
	private int comments;
	// status - 0: 진행, 1: 마감
	private int status;
	private int blockNo;
	private String txHash;
	private String author;
	
	@Override
	public String toString() {
		return "Survey [no=" + no + ", memberId=" + memberId + ", category=" + category + ", title=" + title
				+ ", content=" + content + ", goalParticipants=" + goalParticipants + ", currentParticipants="
				+ currentParticipants + ", regDate=" + regDate + ", deadline=" + deadline + ", paid=" + paid + ", fee="
				+ fee + ", likes=" + likes + ", comments=" + comments + ", status=" + status + ", blockNo=" + blockNo
				+ ", txHash=" + txHash + ", author=" + author + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(int blockNo) {
		this.blockNo = blockNo;
	}

	public String getTxHash() {
		return txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getCurrentParticipants() {
		return currentParticipants;
	}

	public void setCurrentParticipants(int currentParticipants) {
		this.currentParticipants = currentParticipants;
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
}
