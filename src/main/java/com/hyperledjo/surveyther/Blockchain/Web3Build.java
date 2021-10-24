package com.hyperledjo.surveyther.Blockchain;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.methods.response.EthMining;
import org.web3j.protocol.http.HttpService;

@Component
public class Web3Build {

	private Admin admin;
	
	public Web3Build() {
		this.admin = Admin.build(new HttpService("http://152.70.245.107:8545"));
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	public void shutdownAdmin() throws Exception {
		admin.shutdown();
	}
}
