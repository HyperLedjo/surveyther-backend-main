package com.hyperledjo.surveyther.Contract;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import com.hyperledjo.surveyther.Config.UrlConfig;

@Service
public class WalletContract {
	
	private UrlConfig url;
	
	public WalletContract(UrlConfig url) {
		// TODO Auto-generated constructor stub
		this.url = url;
	}
	
	public void getEthClientVersionSync() throws Exception
    {
		Web3j web3 = Web3j.build(new HttpService("rpc://192.168.235.130:18545"));
		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
		System.out.println(clientVersion);
    }
}
