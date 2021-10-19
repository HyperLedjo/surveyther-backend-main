package com.hyperledjo.surveyther.Contract;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

@Service
public class WalletContract {
	
	public void getEthClientVersionSync() throws Exception
    {
		Web3j web3 = Web3j.build(new HttpService("http://152.70.245.107:8545"));
		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
		System.out.println(clientVersion);
    }
}
