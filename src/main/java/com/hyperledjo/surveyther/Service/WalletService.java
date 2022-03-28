package com.hyperledjo.surveyther.Service;

import com.hyperledjo.surveyther.DAO.WalletDAO;
import com.hyperledjo.surveyther.DTO.Wallet;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

	private WalletDAO walletDAO;
	
	public WalletService(WalletDAO walletDAO) {
		this.walletDAO = walletDAO;
	}
	
	public Wallet getWallet(int id) {
		return walletDAO.getWallet(id);
	}
}
