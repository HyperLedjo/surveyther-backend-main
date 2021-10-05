package com.hyperledjo.surveyther.DTO;

public class Shop {
	private int no;
	private String name;

	@Override
	public String toString() {
		return "Shop [no=" + no + ", name=" + name + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
