package com.hyperledjo.surveyther.DTO;

import java.sql.Timestamp;

public class SurveyOrder {
	private int no;
	private int memberId;
	private int surveyId;
	private int paymentId;
	private double price;
	private double paid;
	private Timestamp date;

	@Override
	public String toString() {
		return "SurveyOrder [no=" + no + ", memberId=" + memberId + ", surveyId=" + surveyId + ", paymentId="
				+ paymentId + ", price=" + price + ", paid=" + paid + ", date=" + date + "]";
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

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}
