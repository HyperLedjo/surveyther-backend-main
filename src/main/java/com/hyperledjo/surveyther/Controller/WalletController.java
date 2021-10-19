package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.Contract.WalletContract;
import com.hyperledjo.surveyther.DTO.Wallet;

@RestController
@RequestMapping("/api")
public class WalletController {

	private WalletContract wallet;

	public WalletController(WalletContract wallet) {
		// TODO Auto-generated constructor stub
		this.wallet = wallet;
	}

	@GetMapping("/wallet_test")
	public void walletTest() {
		try {
			wallet.getEthClientVersionSync();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping("/wallet")
	public String postWallet() {
		return null;
	}

	@GetMapping("/wallet/{id}")
	public Wallet getWallet(@PathVariable("id") String id) {

		return null;
	}

	@GetMapping("/wallet")
	public List<Wallet> getWalletList() {
		return null;
	}
}
