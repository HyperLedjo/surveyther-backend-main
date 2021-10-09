package com.hyperledjo.surveyther.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SurveyScheduler {

	/*
	 * 매일 오후 11시 59분 59초가 되면 survey의 deadline을 검사하고 마감되어야 할 survey를 status 1로 바꾸어 마감
	 */
	@Scheduled(cron = "59 59 23 * * ?")
	public void closeSurvey() {
		//
	}
}
