package com.hyperledjo.surveyther.Controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;
import org.web3j.protocol.exceptions.TransactionException;

import com.hyperledjo.surveyther.Blockchain.WalletContract;
import com.hyperledjo.surveyther.Blockchain.Web3Contract;
import com.hyperledjo.surveyther.DTO.Wallet;
import com.hyperledjo.surveyther.Service.WalletService;

@RestController
@RequestMapping("/api")
public class WalletController {

	private Web3Contract wc;
	
	public WalletController(Web3Contract wc) {
		// TODO Auto-generated constructor stub
		this.wc = wc;
	}
	
	
	@GetMapping("/web3/test/store")
	public void web3TestStore() throws Exception {
		wc.regSurveyStore("store", 1, 1, "2021-10-13");
	}
	
	@GetMapping("/web3/test/retrieve")
	public void web3Test() throws IOException {
		wc.regSurveyRetrieve("retrieve", 1);
	}

}
