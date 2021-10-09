package com.hyperledjo.surveyther.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.Service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {

	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		// TODO Auto-generated constructor stub
		this.paymentService = paymentService;
	}
	/*
	 * @GetMapping("/payment") public void payment(HttpServletResponse response) {
	 * JsonNode jsonNode = paymentService.payment();
	 * 
	 * System.out.println(jsonNode);
	 * 
	 * try { response.sendRedirect("http://localhost:8081"); } catch (IOException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

}
