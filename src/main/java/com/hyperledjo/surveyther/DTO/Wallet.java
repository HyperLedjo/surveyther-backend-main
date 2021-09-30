package com.hyperledjo.surveyther.DTO;

public class Wallet {
	private int no;
	private int memberId;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Wallet [no=" + no + ", memberId=" + memberId + ", address=" + address + "]";
	}
}
