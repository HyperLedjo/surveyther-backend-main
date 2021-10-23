package com.hyperledjo.surveyther.Blockchain;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

@Component
public class Web3Contract {

	private static final Logger logger = LogManager.getLogger(Web3Contract.class);
	private Web3Transaction web3Transaction;

	public Web3Contract(Web3Transaction web3Transaction) {
		this.web3Transaction = web3Transaction;
	}

	public String regSurveyStore(String getMethodName, int mId, int sId, String rDate) throws Exception {

		String contractAddress = "0xA57B8a5584442B467b4689F1144D269d096A3daF";
		Function function = new Function(getMethodName,
				Arrays.asList(new Uint256(mId), new Uint256(sId), new Utf8String(rDate)), Collections.emptyList());

		String txHash = web3Transaction.sendRegSurveyTransaction(function, contractAddress);
		TransactionReceipt receipt = web3Transaction.getReceipt(txHash);

		logger.info("[Web3Contract, receipt] " + receipt);

		return receipt.toString();
	}

	public List<Type> regSurveyRetrieve(String getMethodName, int id) throws IOException {
		String contractAddress = "0xA57B8a5584442B467b4689F1144D269d096A3daF";
		Function function = new Function(getMethodName, Arrays.asList(new Uint256(id)),
				Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint>>() {
				}, new TypeReference<DynamicArray<Utf8String>>() {
				}));
		return web3Transaction.callRegSurveyRetrieve(function, contractAddress);
	}

}
