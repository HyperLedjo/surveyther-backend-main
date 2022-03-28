package com.hyperledjo.surveyther.Controller;

import com.hyperledjo.surveyther.Blockchain.Web3Build;
import com.hyperledjo.surveyther.Blockchain.Web3Common;
import com.hyperledjo.surveyther.Blockchain.Web3Transaction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WalletController {

	private Web3Transaction web3Transaction;
	private Web3Common web3Common;

	public WalletController(Web3Common web3Common, Web3Transaction web3Transaction) {
		// TODO Auto-generated constructor stub
		this.web3Common = web3Common;
		this.web3Transaction = web3Transaction;
	}

	@PostMapping("/transferEth")
	public String transferEth(@RequestBody String recipient) {
		return web3Transaction.transferEth(recipient);
	}

	@PostMapping("/ethGetBalance")
	public String ethGetBalance(@RequestBody String recipient) {
		return web3Common.ethGetBalance(recipient);
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
}
