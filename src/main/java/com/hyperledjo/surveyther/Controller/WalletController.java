package com.hyperledjo.surveyther.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.DTO.Wallet;

@RestController
@RequestMapping("/api")
public class WalletController {
	
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
