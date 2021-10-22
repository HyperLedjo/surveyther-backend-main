package com.hyperledjo.surveyther.Blockchain;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

@Component
public class WalletContract {

	private static final Admin admin = Admin.build(new HttpService("http://152.70.245.107:8545"));

	public void createWallet() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
			NoSuchProviderException, CipherException, IOException {
		String fileName = WalletUtils.generateNewWalletFile("wjdqhqhdks", new File(
				"C:\\Users\\H4NKYUL\\Documents\\final-project\\surveyther-backend-main\\src\\main\\resources\\wallet"));
		System.out.println(fileName);

		Credentials credentials = WalletUtils.loadCredentials("wjdqhqhdks", new File(
				"C:\\Users\\H4NKYUL\\Documents\\final-project\\surveyther-backend-main\\src\\main\\resources\\wallet\\"+fileName));
		
		System.out.println(credentials.getAddress());
		System.out.println(credentials.getEcKeyPair().getPrivateKey());

	}

	public void testGetBalances() throws IOException, CipherException {

		Credentials c = WalletUtils.loadCredentials("wjdqhqhdks", new File(
				"C:\\Users\\H4NKYUL\\Documents\\final-project\\surveyther-backend-main\\src\\main\\resources\\wallet\\UTC--2021-10-20T18-16-03.233956200Z--4b567c83715361df8eba1edaffc5eb758e927987.json"));
		ECKeyPair ecKeyPair = c.getEcKeyPair();
		BigInteger privateKeyInDec = ecKeyPair.getPrivateKey();
		String sPrivateKeyIndex = privateKeyInDec.toString(16);

		System.out.println("11111111111111");
		System.out.println(c.getAddress().toString() + " , " + sPrivateKeyIndex);

		PersonalListAccounts p = admin.personalListAccounts().send();
//		List<String> s = p.getResult();
		List<String> s = p.getAccountIds();
		for (String z : s) {
			System.out.println(z);

		}
		EthGetBalance getB = admin.ethGetBalance(s.get(0), DefaultBlockParameterName.LATEST).send();
		EthGetBalance getC = admin
				.ethGetBalance("0x612829bec14113670ec9e75e4d094715ff89f3c3", DefaultBlockParameterName.LATEST).send();

		BigInteger bi = getB.getBalance();
		BigInteger bi2 = getC.getBalance();
		bi = Convert.toWei(bi.toString(), Unit.ETHER).toBigInteger();
		bi2 = Convert.toWei(bi2.toString(), Unit.ETHER).toBigInteger();
		System.out.println(bi.toString() + ", " + bi2.toString());
	}

	public void testEth() throws InterruptedException, ExecutionException, IOException, TransactionException {
		// eth를 송금하려면 보내는 사람의 개인키와 받는 사람의 지갑주소가 필요하다.
		TransactionReceipt receipt = Transfer
				.sendFunds(admin,
						Credentials.create("0x4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d"),
						"0x612829bec14113670ec9e75e4d094715ff89f3c3", new BigDecimal("10"), Convert.Unit.ETHER)
				.sendAsync().get();
		System.err.println(receipt.getTransactionHash());
	}

	public void test1() throws Exception {
		// 이 아래 코드는 쓸모 없다. passphrase로 생성하는 wallet 생성 도구가 필요하다.
		String seed = UUID.randomUUID().toString();

		ECKeyPair ecKeyPair = Keys.createEcKeyPair();
		BigInteger privateKeyInDec = ecKeyPair.getPrivateKey();

		String sPrivateKeyIndex = privateKeyInDec.toString(16);

		WalletFile aWallet = Wallet.createLight(seed, ecKeyPair);
		String aAddress = aWallet.getAddress();

		System.out.println("0x" + aAddress);
		System.out.println(sPrivateKeyIndex);
	}

	public String ethSendTransaction(Function function) throws Exception {
		String from = "0x612829bec14113670ec9e75e4d094715ff89f3c3";

		PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(from, "wjdqhqhdks").send();
		if (personalUnlockAccount.accountUnlocked()) {
			EthGetTransactionCount ethGetTransactionCount = admin
					.ethGetTransactionCount(from, DefaultBlockParameterName.LATEST).sendAsync().get();
			BigInteger nonce = ethGetTransactionCount.getTransactionCount();
			Transaction transaction = Transaction.createFunctionCallTransaction(from, nonce, Transaction.DEFAULT_GAS,
					null, "0xe78A0F7E598Cc8b0Bb87894B0F60dD2a88d6a8Ab", FunctionEncoder.encode(function));

			EthSendTransaction ethSendTransaction = admin.ethSendTransaction(transaction).send();

			String transactionHash = ethSendTransaction.getTransactionHash();

			Thread.sleep(5000);

			return transactionHash;
		} else {
			throw new Exception("Check PersonalLock!");
		}
	}

	public TransactionReceipt getReceipt(String transactionHash) throws IOException {

		// 8. transaction Hash를 통한 receipt 가져오기.
		EthGetTransactionReceipt transactionReceipt = admin.ethGetTransactionReceipt(transactionHash).send();

		if (transactionReceipt.getTransactionReceipt().isPresent()) {
			// 9. 결과확인
			System.out
					.println("transactionReceipt.getResult().getContractAddress() = " + transactionReceipt.getResult());
		} else {
			System.out.println("transaction complete not yet");
		}

		return transactionReceipt.getResult();
	}

	// set test
	public void store(int num) throws Exception {
		Function function = new Function("store", Arrays.asList(new Uint256(num)), Collections.emptyList());

		String txHash = this.ethSendTransaction(function);

		TransactionReceipt receipt = this.getReceipt(txHash);
		System.out.println("r " + receipt);
	}

	public String ethCall(Function function) throws IOException {
//		String from = "0x90f8bf6a479f320ead074411a4b0e7944ea8c9c1";
		String from = "0x612829bec14113670ec9e75e4d094715ff89f3c3";

		Transaction t = Transaction.createEthCallTransaction(from, "0xe78A0F7E598Cc8b0Bb87894B0F60dD2a88d6a8Ab",
				FunctionEncoder.encode(function));

		EthCall ethCall = admin.ethCall(t, DefaultBlockParameterName.LATEST).send();

		List<Type> decode = FunctionReturnDecoder.decode(ethCall.getResult(), function.getOutputParameters());

		System.out.println(ethCall.getResult());
		System.out.println(decode.get(0).getValue());
		System.out.println(decode.get(0).getTypeAsString());

		return decode.get(0).getValue().toString();
	}

	public String test() throws Exception {

		Function function = new Function("retrieve", Collections.emptyList(),
				Arrays.asList(new TypeReference<Uint256>() {
				}));

		return this.ethCall(function);

//		Admin admin = Admin.build(new HttpService("http://152.70.245.107:8545"));
//		Web3ClientVersion web3ClientVersion = admin.web3ClientVersion().send();
//		String v = web3ClientVersion.getWeb3ClientVersion();
//		System.out.println(v);
//		NewAccountIdentifier newAccountId = admin.personalNewAccount("wjdqhqhdks").send();
//		String my = newAccountId.getResult();
//		System.out.println("my: " + my);
//		EthAccounts test = admin.ethAccounts().send();
//		
//		System.out.println(test.getJsonrpc());
//		PersonalListAccounts p = admin.personalListAccounts().send();
//		List<String> s = p.getResult();
//		List<String> s = p.getAccountIds();
//		for (String z : s) {
//			System.out.println(z);
//		}
//		System.out.println("latest: " + s.get(s.size() - 1));

//		EthGetBalance getB = admin.ethGetBalance(s.get(s.size() - 1), DefaultBlockParameterName.LATEST).send();
//		BigInteger bi = getB.getBalance();
//		System.out.println(bi.toString());

//		Web3j web3 = Web3j.build(new HttpService("http://152.70.245.107:8545"));
//		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
//		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//		System.out.println(clientVersion);
//
//		String add = "0x7d50d8ba74a39dee303a25bf060d252d9f8ed5b7";
//		EthGetTransactionCount ec = web3.ethGetTransactionCount(add, DefaultBlockParameterName.LATEST).sendAsync().get();
//		BigInteger nonce = ec.getTransactionCount();
//		EthAccounts a = web3.ethAccounts().send();
//		List<String> b = a.getAccounts();
//		for (String c: b) {
//			System.out.println(c);
//		}
//		
//		System.out.println(nonce);
//		String walletFileName = WalletUtils.generateFullNewWalletFile("wjdqhqhdks" ,new File("C:\\Users\\H4NKYUL\\Documents\\final-project\\surveyther-backend-main\\src\\main\\resources\\wallet"));
//		String[] fetchAddress=walletFileName.split("--");
//		
//		String getAddress = fetchAddress[fetchAddress.length-1].split("\\.")[0];
//		
//		Credentials credentials = WalletUtils.loadCredentials("wjdqhqhdks", "C:\\Users\\H4NKYUL\\Documents\\final-project\\surveyther-backend-main\\src\\main\\resources\\wallet\\"+walletFileName);
//		
//		System.out.println(credentials.getAddress());
//		
//		System.out.println(getAddress);
	}
}
