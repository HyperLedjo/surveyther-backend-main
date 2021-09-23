package com.hyperledjo.surveyther.DTO;

import java.sql.Timestamp;

public class Member {
	private int no;
	private String id;
	private String name;
	private String birthYear;
	private String birthday;
	private String gender;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	private String zipCode;
	private String residence;
	private String job;
	private boolean married;
	private String academic;
	private int income;
	private String wallet;
	private Timestamp regDate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getAcademic() {
		return academic;
	}

	public void setAcademic(String academic) {
		this.academic = academic;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", name=" + name + ", birthYear=" + birthYear + ", birthday="
				+ birthday + ", gender=" + gender + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3
				+ ", email=" + email + ", zipCode=" + zipCode + ", residence=" + residence + ", job=" + job
				+ ", married=" + married + ", academic=" + academic + ", income=" + income + ", wallet=" + wallet
				+ ", regDate=" + regDate + "]";
	}
}
