package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.PaymentsDAO;
import com.hyperledjo.surveyther.DTO.Payments;

@Service
public class PaymentsService {

	private PaymentsDAO paymentsDAO;
	
	public PaymentsService(PaymentsDAO paymentsDAO) {
		this.paymentsDAO = paymentsDAO;
	}
	
	public int postPayments(Payments payments) {
		return paymentsDAO.postPayments(payments);
	}

}
