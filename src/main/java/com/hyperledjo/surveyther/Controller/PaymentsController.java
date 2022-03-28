package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.Config.KeyConfig;
import com.hyperledjo.surveyther.DTO.Payments;
import com.hyperledjo.surveyther.Service.PaymentsService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PaymentsController {

	private IamportClient client;
	private PaymentsService paymentsService;

	public PaymentsController(KeyConfig keyConfig, PaymentsService paymentsService) {
		this.paymentsService = paymentsService;
		this.client = new IamportClient(keyConfig.getPaymentApiKey(), keyConfig.getPaymentSecretKey());
	}
	
	@PostMapping("/payments")
	public int postPayments(@RequestBody Payments payments) {
		return paymentsService.postPayments(payments);
	}
	
	@PostMapping("/payments/{imp_uid}")
	public IamportResponse<Payment> paymentByImpUid(@PathVariable("imp_uid") String impUid){
		try {
			return client.paymentByImpUid(impUid);
		} catch (IamportResponseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
