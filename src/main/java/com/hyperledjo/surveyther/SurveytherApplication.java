package com.hyperledjo.surveyther;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SurveytherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveytherApplication.class, args);
	}

}
