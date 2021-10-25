package com.hyperledjo.surveyther.Controller;

import java.io.IOException;
import java.math.BigInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hyperledjo.surveyther.Blockchain.Web3Build;
import com.hyperledjo.surveyther.Blockchain.Web3Common;
import com.hyperledjo.surveyther.Blockchain.Web3Contract;
import com.hyperledjo.surveyther.Blockchain.Web3Transaction;

@RestController
@RequestMapping("/api")
public class WalletController {

	private Web3Contract wc;
	private Web3Transaction web3Transaction;
	private Web3Common web3Common;

	public WalletController(Web3Contract wc, Web3Common web3Common, Web3Transaction web3Transaction) {
		// TODO Auto-generated constructor stub
		this.wc = wc;
		this.web3Common = web3Common;
		this.web3Transaction = web3Transaction;
	}

	@GetMapping("/transferEth")
	public String transferEth() {
		String address = "0x3e0365e8cd714684a83866966cd30d9a05d55443";
		return web3Transaction.transferEth(address);
	}

	@GetMapping("/ethGetBalance")
	public String ethGetBalance() {
		String address = "0x3e0365e8cd714684a83866966cd30d9a05d55443";
		return web3Common.ethGetBalance(address);
	}

	@GetMapping("/shutdown")
	public int shutdown() {
		Web3Build web3Build = new Web3Build();
		try {
			web3Build.shutdownAdmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	// /api/web3/test/store
	@GetMapping("/web3/test/store")
	public JsonNode web3TestStore() throws Exception {
//		String contractMethodName = "store";
//		BigInteger _memberId = BigInteger.valueOf(1);
//		BigInteger _surveyId = BigInteger.valueOf(1);
//		String _regDate = "2021-10-25";

		BigInteger surveyId = BigInteger.valueOf(1);
		BigInteger memberId = BigInteger.valueOf(1);
		BigInteger questionId = BigInteger.valueOf(27);
		BigInteger answerId = BigInteger.valueOf(23);
		
		return wc.answerResponseSurveyStore(surveyId, memberId, questionId, answerId);
//		return wc.participantSurveyStore(_memberId, _surveyId, _regDate);
//		return wc.regSurveyStore(contractMethodName, _memberId, _surveyId, _regDate);
	}

	// /api/web3/test/retrieve
	@GetMapping("/web3/test/retrieve")
	public JsonNode web3Test() throws Exception {
//		String contractMethodName = "retrieve";
//		BigInteger _memberId = BigInteger.ONE;
		BigInteger memberId = BigInteger.valueOf(1);
		return wc.participantSurveyRetrieve(memberId);
//		return wc.regSurveyRetrieve(contractMethodName, _memberId);
	}

}
