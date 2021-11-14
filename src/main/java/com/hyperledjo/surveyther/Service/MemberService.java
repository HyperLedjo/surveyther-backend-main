package com.hyperledjo.surveyther.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hyperledjo.surveyther.DAO.MemberDAO;
import com.hyperledjo.surveyther.DAO.WalletDAO;
import com.hyperledjo.surveyther.DTO.Member;
import com.hyperledjo.surveyther.DTO.Wallet;

@Service
public class MemberService {

	private MemberDAO memberDAO;
	private WalletDAO walletDAO;

	public MemberService(MemberDAO memberDAO, WalletDAO walletDAO) {
		this.memberDAO = memberDAO;
		this.walletDAO = walletDAO;
	}

	public int patchMember(Member member) {
		return memberDAO.patchMember(member);
	}

	public int postMember(Member member) {
		int result = memberDAO.postMember(member);
		if (result < 1) {
			return -2;
		}
		Wallet wallet = new Wallet();
		wallet.setMemberId(member.getNo());
		result = walletDAO.postWallet(wallet);
		if (result < 1) {
			return -1;
		}
		wallet = walletDAO.getWallet(member.getNo());

		member.setWallet(wallet.getAddress());
		result = memberDAO.uploadWallet(member);

		if (result < 1) {
			return 0;
		}

		// KMS 또는 HMS로 키 관리를 하는데 구현하기 까다로우니 일단 Private Key를 암호화해서 DB에 저장해야 함
		return 1;
	}

	public Member getMember(String id) {
		return memberDAO.getMember(id);
	}

	public List<Member> getMemberList() {
		return memberDAO.getMemberList();
	}

}
