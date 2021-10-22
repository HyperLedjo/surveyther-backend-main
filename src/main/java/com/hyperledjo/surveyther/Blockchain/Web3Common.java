package com.hyperledjo.surveyther.Blockchain;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Component;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;

@Component
public class Web3Common {

	private Web3Build wb;

	public Web3Common(Web3Build wb) {
		this.wb = wb;
	}

	public List<String> getAccountsList() {
		Admin admin = wb.getAdmin();
		PersonalListAccounts accounts = null;
		try {
			accounts = admin.personalListAccounts().send();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return accounts.getAccountIds();
	}

	public String ethGetBalance(String address) {

		Admin admin = wb.getAdmin();
		String balance = null;

		try {
			EthGetBalance ether = admin.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
			BigInteger value = ether.getBalance();
			balance = value.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return balance;
	}
}
