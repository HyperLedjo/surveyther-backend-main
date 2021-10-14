package com.hyperledjo.surveyther.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hyperledjo.surveyther.Config.UrlConfig;
import com.hyperledjo.surveyther.DTO.Survey;
import com.hyperledjo.surveyther.Service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private PaymentService paymentService;
	private UrlConfig urlConfig;

	public PaymentController(PaymentService paymentService, UrlConfig urlConfig) {
		// TODO Auto-generated constructor stub
		this.paymentService = paymentService;
		this.urlConfig = urlConfig;
	}

	// 서베이 구매시 이용
	@PostMapping("/buy")
	public void buy(@RequestBody Survey survey, HttpServletResponse response) {

	}

	// 서베이 등록시 이용
	@PostMapping("/sell")
	public void sell(HttpServletResponse response) {
		JsonNode jsonNode = paymentService.payment();
		System.out.println(jsonNode);

		try {
			response.sendRedirect(urlConfig.getFrontendUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/success")
	public void success(@RequestParam("pg_token") String pgToken) {
		System.out.println(pgToken);
	}

}
