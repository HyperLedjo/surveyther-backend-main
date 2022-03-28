package com.hyperledjo.surveyther.Blockchain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperledjo.surveyther.Contract.AnswerResponseSurvey;
import com.hyperledjo.surveyther.Contract.ParticipantSurvey;
import com.hyperledjo.surveyther.Contract.RegSurvey;
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
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Web3Contract {

	private static final Logger logger = LogManager.getLogger(Web3Contract.class);

	private Web3Transaction web3Transaction;
	private Web3Build web3Build;

	public Web3Contract(Web3Build web3Build, Web3Transaction web3Transaction) {
		this.web3Build = web3Build;
		this.web3Transaction = web3Transaction;
	}

	public JsonNode answerResponseSurveyStore(BigInteger surveyId, BigInteger memberId, BigInteger questionId,
			BigInteger answerId) throws Exception {

		Admin admin = web3Build.getAdmin();
		String pk = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
		Credentials credentials = Credentials.create(pk);
		ContractGasProvider gasProvider = new StaticGasProvider(ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String contractAddress = "0x9561C133DD8580860B6b7E504bC5Aa500f0f06a7";

		AnswerResponseSurvey answerResponseSurvey = AnswerResponseSurvey.load(contractAddress, admin, credentials,
				gasProvider);
		TransactionReceipt receipt = answerResponseSurvey.store(surveyId, memberId, questionId, answerId).send();

		HashMap<Integer, String> hashMap = new HashMap<>();
		int blockNum = receipt.getBlockNumber().intValue();
		String txHash = receipt.getTransactionHash();
		hashMap.put(blockNum, txHash);

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode jsonNode = objMapper.valueToTree(hashMap);

		return jsonNode;
	};

	public JsonNode participantSurveyStore(BigInteger memberId, BigInteger surveyId, String partiDate)
			throws Exception {

		Admin admin = web3Build.getAdmin();
		String pk = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
		Credentials credentials = Credentials.create(pk);
		ContractGasProvider gasProvider = new StaticGasProvider(ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String contractAddress = "0xC89Ce4735882C9F0f0FE26686c53074E09B0D550";

		ParticipantSurvey participantSurvey = ParticipantSurvey.load(contractAddress, admin, credentials, gasProvider);
		TransactionReceipt receipt = participantSurvey.store(memberId, surveyId, partiDate).send();

		HashMap<Integer, String> hashMap = new HashMap<>();
		int blockNum = receipt.getBlockNumber().intValue();
		String txHash = receipt.getTransactionHash();
		hashMap.put(blockNum, txHash);

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode jsonNode = objMapper.valueToTree(hashMap);

		return jsonNode;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> regSurveyStore(BigInteger memberId, BigInteger surveyId, String regDate) throws Exception {

		// 2021-11-14, 컨트랙트를 대리자가 호출하기 전에 검증 가능한 사용자인지를 먼저 체크하는 것이 필요
		// Credential을 Load해서 true면 대리자 서비스 이용 가능하도록 기능 추가 필요
		// Hint : https://medium.com/rayonprotocol/%EC%9D%B4%EB%8D%94%EB%A6%AC%EC%9B%80-%EA%B3%84%EC%A0%95%EC%9C%BC%EB%A1%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%84%9C%EB%AA%85-%EB%B0%8F-%EA%B2%80%EC%A6%9D-5fb856a96cf4
		
		Admin admin = web3Build.getAdmin();
		String pk = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
		Credentials credentials = Credentials.create(pk);
		@SuppressWarnings("deprecation")
		ContractGasProvider gasProvider = new StaticGasProvider(ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		String contractAddress = "0xe78A0F7E598Cc8b0Bb87894B0F60dD2a88d6a8Ab";

		RegSurvey regSurvey = RegSurvey.load(contractAddress, admin, credentials, gasProvider);
		TransactionReceipt receipt = regSurvey.store(memberId, surveyId, regDate).send();

		ObjectMapper objMapper = new ObjectMapper();
		Map<String, String> map;

		int blockNum = receipt.getBlockNumber().intValue();
		String txHash = receipt.getTransactionHash();

		String json = "{\"blockNum\":\"" 
						+ blockNum + "\","
						+ "\"txHash\":\""
						+ txHash + "\""
						+ "}";

		System.out.println(json);
		map = objMapper.readValue(json, Map.class);
//		Function function = new Function(contractMethodName,
//				Arrays.<Type>asList(new Uint2pu56(_memberId), new Uint256(_surveyId), new Utf8String(_regDate)),
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
		return map;
	}

	public void answerResponseSurveyRetrieve(BigInteger surveyId) throws Exception {
		Admin admin = web3Build.getAdmin();
		String contractAddress = "0x9561C133DD8580860B6b7E504bC5Aa500f0f06a7";
		String pk = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
		Credentials credentials = Credentials.create(pk);
		ContractGasProvider gasProvider = new StaticGasProvider(ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

		AnswerResponseSurvey answerResponseSurvey = AnswerResponseSurvey.load(contractAddress, admin, credentials,
				gasProvider);

		Tuple3<List<BigInteger>, List<BigInteger>, List<BigInteger>> results = answerResponseSurvey.retrieve(surveyId)
				.send();
	};

	public JsonNode participantSurveyRetrieve(BigInteger memberId) throws Exception {
		Admin admin = web3Build.getAdmin();
		String contractAddress = "0xC89Ce4735882C9F0f0FE26686c53074E09B0D550";
		String pk = "0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d";
		Credentials credentials = Credentials.create(pk);
		ContractGasProvider gasProvider = new StaticGasProvider(ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

		ParticipantSurvey participantSurvey = ParticipantSurvey.load(contractAddress, admin, credentials, gasProvider);

		Tuple2<List<BigInteger>, List<String>> results = participantSurvey.retrieve(memberId).send();

//		System.out.println(results.toString());
//		Tuple2{value1=[1, 2, 3], value2=[2021-10-25, 2021-10-25, 2021-10-25]}
		HashMap<BigInteger, String> hashMap = new HashMap<>();
		List<BigInteger> uIntValue = results.getValue1();
		List<String> utf8StringValue = results.getValue2();

		for (int i = 0; i < uIntValue.size(); i++) {
			hashMap.put(uIntValue.get(i), utf8StringValue.get(i));
		}

		ObjectMapper objMapper = new ObjectMapper();
		JsonNode jsonNode = objMapper.valueToTree(hashMap);

//		System.out.println(jsonNode.toString());
//		{"1":"2021-10-25","2":"2021-10-25","3":"2021-10-25"}

		return jsonNode;
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
