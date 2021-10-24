package com.hyperledjo.surveyther.Blockchain;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Web3Transaction {

	private Web3Build wb;

	private static final Logger logger = LogManager.getLogger(Web3Transaction.class);

	public Web3Transaction(Web3Build wb) {
		// TODO Auto-generated constructor stub
		this.wb = wb;
	}

//	public String sendRegSurveyTransaction(Function function, String contractAddress) throws Exception {
//		Admin admin = wb.getAdmin();
//		String from = "0x90F8bf6A479f320ead074411a4B0e7944Ea8c9C1";
////		String from = "0x3e0365e8cd714684a83866966cd30d9a05d55443";
//		String txHash = null;
//
//		PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(from, "surveyther").send();
//		if (personalUnlockAccount.accountUnlocked()) {
//
//			EthGetTransactionCount ethGetTransactionCount = admin
//					.ethGetTransactionCount(from, DefaultBlockParameterName.LATEST).send();
//
//			BigInteger nonce = ethGetTransactionCount.getTransactionCount();
//
//			Transaction transaction = Transaction.createFunctionCallTransaction(from, nonce, Transaction.DEFAULT_GAS,
//					null, contractAddress, FunctionEncoder.encode(function));
//			EthSendTransaction ethSendTransaction = admin.ethSendTransaction(transaction).send();
//
//			txHash = ethSendTransaction.getTransactionHash();
//
//			Thread.sleep(5000);
//
//			logger.info("[Web3Transaction, txHash] " + txHash);
//			return txHash;
//		} else {
//			throw new Exception();
//		}
//	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonNode callRegSurveyRetrieve(Function function, String contractAddress) throws IOException {
		Admin admin = wb.getAdmin();
		String from = "0x90F8bf6A479f320ead074411a4B0e7944Ea8c9C1";

		Transaction t = Transaction.createEthCallTransaction(from, contractAddress, FunctionEncoder.encode(function));
		List<Type> decode = null;
		try {
			EthCall ethCall = admin.ethCall(t, DefaultBlockParameterName.LATEST).send();
			decode = FunctionReturnDecoder.decode(ethCall.getValue(), function.getOutputParameters());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		HashMap<BigInteger, String> hashMap = new HashMap<>();
		List<Uint> uIntValue = (List<Uint>) decode.get(0).getValue();
		List<Utf8String> utf8StringValue = (List<Utf8String>) decode.get(1).getValue();

		for (int i = 0; i < uIntValue.size(); i++) {
			hashMap.put(uIntValue.get(i).getValue(), utf8StringValue.get(i).getValue());
		}

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode jsonNode = objMapper.valueToTree(hashMap);

		logger.info("[Web3Transaction, decode] " + jsonNode);

		return jsonNode;
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
	
//	public TransactionReceipt getReceipt(String transactionHash) throws IOException {
//
//		Admin admin = wb.getAdmin();
//
//		EthGetTransactionReceipt transactionReceipt = admin.ethGetTransactionReceipt(transactionHash).send();
//
//		if (transactionReceipt.getTransactionReceipt().isPresent()) {
//			logger.info("[Web3Contract, txReceipt] " + transactionReceipt.getResult());
//		} else {
//			logger.info("[Web3Contract, txReceipt, Error] Transaction complete not yet!");
//		}
//
//		return transactionReceipt.getResult();
//	}
}
