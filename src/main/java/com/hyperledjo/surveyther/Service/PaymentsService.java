package com.hyperledjo.surveyther.Service;

import com.hyperledjo.surveyther.DAO.PaymentsDAO;
import com.hyperledjo.surveyther.DTO.Payments;
import org.springframework.stereotype.Service;

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
