package com.hyperledjo.surveyther.Scheduler;

import com.hyperledjo.surveyther.DAO.SurveyDAO;
import com.hyperledjo.surveyther.DTO.Survey;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SurveyScheduler {

	private SurveyDAO surveyDAO;

	public SurveyScheduler(SurveyDAO surveyDAO) {
		this.surveyDAO = surveyDAO;
	}

	/*
	 * 매일 오후 11시 59분 59초가 되면 survey의 deadline을 검사하고 마감되어야 할 survey를 status 1로 바꾸어 마감
	 */
	@Scheduled(cron = "59 59 23 * * ?")
//	@Scheduled(fixedDelay=5000)
	public void closeSurvey() {
		String now = LocalDate.now().toString();
//		String now = "2021-10-17";
		List<Survey> surveyToCloseList = surveyDAO.getSurveyToCloseList(now);
		
		for(Survey s : surveyToCloseList) {
			if(s.getStatus() != 1) {
				surveyDAO.closeSurvey(s.getNo());
			}
		}
	}
}
