package com.hyperledjo.surveyther.Contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class AnswerResponseSurvey extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610471806100206000396000f30060806040526004361061004b5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416638f88708b8114610050578063f58a284514610088575b600080fd5b34801561005c57600080fd5b5061007061006b3660046102fe565b6100aa565b60405161007f939291906103eb565b60405180910390f35b34801561009457600080fd5b506100a86100a3366004610324565b6101c7565b005b60008181526002602081815260409283902080548451818402810184019095528085526060948594859460018501939185019291859183018282801561010f57602002820191906000526020600020905b8154815260200190600101908083116100fb575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561016157602002820191906000526020600020905b81548152602001906001019080831161014d575b50505050509150808054806020026020016040519081016040528092919081815260200182805480156101b357602002820191906000526020600020905b81548152602001906001019080831161019f575b505050505090509250925092509193909250565b6000848152600260208181526040808420805460018181018355828752848720909101899055808201805480830182559087528487200188905581850180548083018255908752848720018790558986528084529185209383528354918201808555938552919093208154929391926003909202019061024a908290849061027e565b506001828101805461025f928401919061027e565b5060028281018054610274928401919061027e565b5050505050505050565b8280548282559060005260206000209081019282156102be5760005260206000209182015b828111156102be5782548255916001019190600101906102a3565b506102ca9291506102ce565b5090565b6102e891905b808211156102ca57600081556001016102d4565b90565b60006102f782356102e8565b9392505050565b60006020828403121561031057600080fd5b600061031c84846102eb565b949350505050565b6000806000806080858703121561033a57600080fd5b600061034687876102eb565b9450506020610357878288016102eb565b9350506040610368878288016102eb565b9250506060610379878288016102eb565b91505092959194509250565b600061039082610433565b8084526020840193506103a28361042d565b60005b828110156103d2576103b88683516103dc565b6103c18261042d565b6020969096019591506001016103a5565b5093949350505050565b6103e5816102e8565b82525050565b606080825281016103fc8186610385565b905081810360208301526104108185610385565b905081810360408301526104248184610385565b95945050505050565b60200190565b51905600a265627a7a723058200f579e7809c2e2f6e5f7ddc2aad6eadc7fc5d81b854825e8feb05473422ff4346c6578706572696d656e74616cf50037";

    public static final String FUNC_RETRIEVE = "retrieve";

    public static final String FUNC_STORE = "store";

    @Deprecated
    protected AnswerResponseSurvey(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AnswerResponseSurvey(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AnswerResponseSurvey(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AnswerResponseSurvey(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple3<List<BigInteger>, List<BigInteger>, List<BigInteger>>> retrieve(BigInteger surveyId) {
        final Function function = new Function(FUNC_RETRIEVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(surveyId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<Tuple3<List<BigInteger>, List<BigInteger>, List<BigInteger>>>(function,
                new Callable<Tuple3<List<BigInteger>, List<BigInteger>, List<BigInteger>>>() {
                    @Override
                    public Tuple3<List<BigInteger>, List<BigInteger>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<BigInteger>, List<BigInteger>, List<BigInteger>>(
                                convertToNative((List<Uint256>) results.get(0).getValue()), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                convertToNative((List<Uint256>) results.get(2).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> store(BigInteger surveyId, BigInteger memberId, BigInteger questionId, BigInteger answerId) {
        final Function function = new Function(
                FUNC_STORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(surveyId), 
                new org.web3j.abi.datatypes.generated.Uint256(memberId), 
                new org.web3j.abi.datatypes.generated.Uint256(questionId), 
                new org.web3j.abi.datatypes.generated.Uint256(answerId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AnswerResponseSurvey load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AnswerResponseSurvey(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AnswerResponseSurvey load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AnswerResponseSurvey(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AnswerResponseSurvey load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AnswerResponseSurvey(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AnswerResponseSurvey load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AnswerResponseSurvey(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AnswerResponseSurvey> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AnswerResponseSurvey.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AnswerResponseSurvey> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AnswerResponseSurvey.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AnswerResponseSurvey> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AnswerResponseSurvey.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AnswerResponseSurvey> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AnswerResponseSurvey.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
