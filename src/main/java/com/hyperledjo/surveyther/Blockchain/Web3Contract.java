package com.hyperledjo.surveyther.Blockchain;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import com.fasterxml.jackson.databind.JsonNode;
import com.hyperledjo.surveyther.Contract.RegSurvey;

@Component
public class Web3Contract {

	private static final Logger logger = LogManager.getLogger(Web3Contract.class);
	
	private Web3Transaction web3Transaction;
	private Web3Build web3Build;

	public Web3Contract(Web3Build web3Build, Web3Transaction web3Transaction) {
		this.web3Build = web3Build;
		this.web3Transaction = web3Transaction;
	}

	public String regSurveyStore(String contractMethodName, BigInteger memberId, BigInteger surveyId, String regDate)
			throws Exception {

		Admin admin = web3Build.getAdmin();
		
		String pk = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
		Credentials credentials = Credentials.create(pk);
		
	    ContractGasProvider gasProvider = new StaticGasProvider(ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		
		String contractAddress = "0xe78A0F7E598Cc8b0Bb87894B0F60dD2a88d6a8Ab";
		RegSurvey regSurvey = RegSurvey.load(contractAddress, admin, credentials, gasProvider);
//		String cAddress = regSurvey.getContractAddress();
		TransactionReceipt receipt = regSurvey.store(memberId, surveyId, regDate).send();
	
//		Function function = new Function(contractMethodName,
//				Arrays.<Type>asList(new Uint256(_memberId), new Uint256(_surveyId), new Utf8String(_regDate)),
//				Collections.<TypeReference<?>>emptyList());
//
//		String txData = FunctionEncoder.encode(function);
//		TransactionManager txManager = new RawTransactionManager(admin, credentials);
//
//		String txHash = txManager.sendTransaction(DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT,
//				contractAddress, txData, BigInteger.ONE).getTransactionHash();
//
//		TransactionReceiptProcessor receiptProcessor = new PollingTransactionReceiptProcessor(admin,
//				TransactionManager.DEFAULT_POLLING_FREQUENCY, TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);
//
//		TransactionReceipt receipt = receiptProcessor.waitForTransactionReceipt(txHash);
//		
//		Thread.sleep(3000);
		
//		Function function = new Function(contractMethodName,
//				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_memberId),
//						new org.web3j.abi.datatypes.generated.Uint256(_surveyId),
//						new org.web3j.abi.datatypes.Utf8String(_regDate)),
//				Collections.<TypeReference<?>>emptyList());
//		
//		String txHash = web3Transaction.sendRegSurveyTransaction(function, contractAddress);
//		TransactionReceipt receipt = web3Transaction.getReceipt(txHash);
//
//		logger.info("[Web3Contract, receipt] " + receipt);
//
		return receipt.toString();
	}

	@SuppressWarnings("rawtypes")
	public JsonNode regSurveyRetrieve(String contractMethodName, BigInteger _memberId) throws IOException {
		String contractAddress = "0xe78A0F7E598Cc8b0Bb87894B0F60dD2a88d6a8Ab";
		Function function = new Function(contractMethodName,
				Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_memberId)),
				Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {
				}, new TypeReference<DynamicArray<Utf8String>>() {
				}));
		return web3Transaction.callRegSurveyRetrieve(function, contractAddress);
	}

}
