package com.hyperledjo.surveyther.Blockchain;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.stereotype.Component;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;

@Component
public class Web3Contract {

	private Web3Transaction web3Transaction;

	public Web3Contract(Web3Transaction web3Transaction) {
		this.web3Transaction = web3Transaction;
	}

	@SuppressWarnings({ "rawtypes" })
	public String get(String getMethodName) {

		Function function = new Function(getMethodName, Arrays.asList(new Uint256(1)),
				Arrays.asList(new TypeReference<Type>() {}));
//
//		Function function = new Function(getMethodName, Collections.emptyList(),
//				Arrays.asList(new TypeReference<Type>() {
//				}));

		return web3Transaction.ethCall(function);
	}

}
