package com.hyperledjo.surveyther.Blockchain;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

@Component
public class Web3Transaction {

	private Web3Build wb;

	public Web3Transaction(Web3Build wb) {
		// TODO Auto-generated constructor stub
		this.wb = wb;
	}

	public String ethCall(Function function) {
		Admin admin = wb.getAdmin();
		String from = "0x90f8bf6a479f320ead074411a4b0e7944ea8c9c1";
		
		Transaction t = Transaction.createEthCallTransaction(from, "0x5Cca2cF3f8a0e5a5aF6A1E9A54A0c98510D92081",
				FunctionEncoder.encode(function));
		
		@SuppressWarnings("rawtypes")
		List<Type> decode = null;
		
		try {
			EthCall ethCall = admin.ethCall(t, DefaultBlockParameterName.LATEST).send();
			decode = FunctionReturnDecoder.decode(ethCall.getResult(), function.getOutputParameters());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		decode.forEach(name -> System.out.println(name));
		
		return null;
	}

	public String transferEth(String recipient) {

		Admin admin = wb.getAdmin();
		String txHash = null;
		try {
			TransactionReceipt receipt = Transfer.sendFunds(admin,
					Credentials.create("0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d"), recipient,
					new BigDecimal("10"), Convert.Unit.ETHER).sendAsync().get();
			txHash = receipt.getTransactionHash();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return txHash;
	}
}
