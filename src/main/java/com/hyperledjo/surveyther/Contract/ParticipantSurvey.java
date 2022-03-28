package com.hyperledjo.surveyther.Contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class ParticipantSurvey extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506107a7806100206000396000f30060806040526004361061004b5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166370ef6e0b81146100505780638f88708b14610072575b600080fd5b34801561005c57600080fd5b5061007061006b366004610542565b6100a9565b005b34801561007e57600080fd5b5061009261008d36600461051c565b610152565b6040516100a09291906106a9565b60405180910390f35b6000838152600260209081526040822080546001818101835582855283852090910186905590810180549182018082559084529282902084516100f493919092019190850190610292565b5050600083815260016020818152604080842060028084529185208154948501808355918652929094208254929390910201906101349082908490610310565b50600182810180546101499284019190610350565b50505050505050565b60008181526002602090815260409182902080548351818402810184019094528084526060938493600184019284918301828280156101b057602002820191906000526020600020905b81548152602001906001019080831161019c575b5050505050915080805480602002602001604051908101604052809291908181526020016000905b828210156102835760008481526020908190208301805460408051601f600260001961010060018716150201909416939093049283018590048502810185019091528181529283018282801561026f5780601f106102445761010080835404028352916020019161026f565b820191906000526020600020905b81548152906001019060200180831161025257829003601f168201915b5050505050815260200190600101906101d8565b50505050905091509150915091565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106102d357805160ff1916838001178555610300565b82800160010185558215610300579182015b828111156103005782518255916020019190600101906102e5565b5061030c9291506103ba565b5090565b8280548282559060005260206000209081019282156103005760005260206000209182015b82811115610300578254825591600101919060010190610335565b8280548282559060005260206000209081019282156103ae5760005260206000209182015b828111156103ae578282908054600181600116156101000203166002900461039e9291906103d7565b5091600101919060010190610375565b5061030c92915061044b565b6103d491905b8082111561030c57600081556001016103c0565b90565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106104105780548555610300565b8280016001018555821561030057600052602060002091601f0160209004820182811115610300578254825591600101919060010190610335565b6103d491905b8082111561030c576000610465828261046e565b50600101610451565b50805460018160011615610100020316600290046000825580601f1061049457506104b2565b601f0160209004906000526020600020908101906104b291906103ba565b50565b6000601f820183136104c657600080fd5b81356104d96104d4826106f5565b6106ce565b915080825260208301602083018583830111156104f557600080fd5b610500838284610727565b50505092915050565b600061051582356103d4565b9392505050565b60006020828403121561052e57600080fd5b600061053a8484610509565b949350505050565b60008060006060848603121561055757600080fd5b60006105638686610509565b935050602061057486828701610509565b925050604084013567ffffffffffffffff81111561059157600080fd5b61059d868287016104b5565b9150509250925092565b60006105b282610723565b808452602084019350836020820285016105cb8561071d565b60005b848110156106025783830388526105e6838351610665565b92506105f18261071d565b6020989098019791506001016105ce565b50909695505050505050565b600061061982610723565b80845260208401935061062b8361071d565b60005b8281101561065b5761064186835161069a565b61064a8261071d565b60209690960195915060010161062e565b5093949350505050565b600061067082610723565b808452610684816020860160208601610733565b61068d81610763565b9093016020019392505050565b6106a3816103d4565b82525050565b604080825281016106ba818561060e565b9050818103602083015261053a81846105a7565b60405181810167ffffffffffffffff811182821017156106ed57600080fd5b604052919050565b600067ffffffffffffffff82111561070c57600080fd5b506020601f91909101601f19160190565b60200190565b5190565b82818337506000910152565b60005b8381101561074e578181015183820152602001610736565b8381111561075d576000848401525b50505050565b601f01601f1916905600a265627a7a72305820d46b41cdb4279f78605121f553a4ac34f1a45ff6515703e0efbe3314ab28fa136c6578706572696d656e74616cf50037";

    public static final String FUNC_STORE = "store";

    public static final String FUNC_RETRIEVE = "retrieve";

    @Deprecated
    protected ParticipantSurvey(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ParticipantSurvey(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ParticipantSurvey(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ParticipantSurvey(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> store(BigInteger memberId, BigInteger surveyId, String partiDate) {
        final Function function = new Function(
                FUNC_STORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(memberId), 
                new org.web3j.abi.datatypes.generated.Uint256(surveyId), 
                new org.web3j.abi.datatypes.Utf8String(partiDate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<List<BigInteger>, List<String>>> retrieve(BigInteger memberId) {
        final Function function = new Function(FUNC_RETRIEVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(memberId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}));
        return new RemoteFunctionCall<Tuple2<List<BigInteger>, List<String>>>(function,
                new Callable<Tuple2<List<BigInteger>, List<String>>>() {
                    @Override
                    public Tuple2<List<BigInteger>, List<String>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<List<BigInteger>, List<String>>(
                                convertToNative((List<Uint256>) results.get(0).getValue()), 
                                convertToNative((List<Utf8String>) results.get(1).getValue()));
                    }
                });
    }

    @Deprecated
    public static ParticipantSurvey load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ParticipantSurvey(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ParticipantSurvey load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ParticipantSurvey(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ParticipantSurvey load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ParticipantSurvey(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ParticipantSurvey load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ParticipantSurvey(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ParticipantSurvey> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ParticipantSurvey.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ParticipantSurvey> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ParticipantSurvey.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ParticipantSurvey> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ParticipantSurvey.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ParticipantSurvey> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ParticipantSurvey.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
