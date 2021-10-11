package com.hyperledjo.surveyther.DTO;

import java.util.List;

public class Test {
	private List<Question> questions;

	@Override
	public String toString() {
		return "Test [questions=" + questions + "]";
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
