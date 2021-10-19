package com.hyperledjo.surveyther.DTO;

import java.sql.Timestamp;

public class Payments {

	private int no; // 결제 테이블 PK
	private int memberId; // 결제 요청한 회원 FK
	private String impUid; // 결제 ID
	private String merchantUid; // 거래 ID
	private String applyNum; // 승인 번호
	private String paidAmount; // 결제 금액
	private String provider; // PG Provider
	private String paymentType; // 결제 방법
	private Timestamp paymentDate;

	@Override
	public String toString() {
		return "Payments [no=" + no + ", memberId=" + memberId + ", impUid=" + impUid + ", merchantUid=" + merchantUid
				+ ", applyNum=" + applyNum + ", paidAmount=" + paidAmount + ", provider=" + provider + ", paymentType="
				+ paymentType + ", paymentDate=" + paymentDate + "]";
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
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

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
}
