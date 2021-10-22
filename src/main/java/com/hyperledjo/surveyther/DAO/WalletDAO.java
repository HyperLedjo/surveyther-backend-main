package com.hyperledjo.surveyther.DAO;

import java.io.File;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import com.hyperledjo.surveyther.Blockchain.Web3Transaction;
import com.hyperledjo.surveyther.DTO.Wallet;

@Repository
public class WalletDAO {

	private String nameSpace = "com.hyperledjo.surveyther.DAO.WalletDAO";
	private SqlSessionTemplate sql;
	private Web3Transaction web3Transaction;

	public WalletDAO(SqlSessionTemplate sql, Web3Transaction web3Transaciton) {
		this.sql = sql;
		this.web3Transaction = web3Transaciton;
	}

	public int postWallet(Wallet wallet) {

		String address = null;
		String privateKey = null;
		try {
			String fileName = WalletUtils.generateNewWalletFile("surveyther", new File(
					"C:\\Users\\H4NKYUL\\Documents\\final-project\\surveyther-backend-main\\src\\main\\resources\\wallet"));
			Credentials credentials = WalletUtils.loadCredentials("surveyther", new File(
					"C:\\Users\\H4NKYUL\\Documents\\final-project\\surveyther-backend-main\\src\\main\\resources\\wallet\\"
							+ fileName));
			address = credentials.getAddress();
			privateKey = credentials.getEcKeyPair().getPrivateKey().toString();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		wallet.setAddress(address);
		wallet.setPrivateKey(privateKey);

		int result = sql.insert(nameSpace + ".postWallet", wallet);
		if(0 < result) {
			web3Transaction.transferEth(address);
		}
		return result;
	}

	public Wallet getWallet(int id) {
		return sql.selectOne(nameSpace + ".getWallet", id);
	}

}
