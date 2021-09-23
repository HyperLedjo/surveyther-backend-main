package com.hyperledjo.surveyther.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hyperledjo.surveyther.DTO.Member;
import com.hyperledjo.surveyther.Service.OAuth2Service;

@RestController
@RequestMapping("/oauth2")
public class OAuth2Controller {

	private OAuth2Service oAuth2Service;

	public OAuth2Controller(OAuth2Service oAuth2Service) {
		this.oAuth2Service = oAuth2Service;
	}

	@GetMapping("/token")
	public String getToken(HttpSession session) {
		String t = session.getAttribute("token").toString();
		if(t.isEmpty()) {
			return "";
		}
		System.out.println(t);
		return session.getAttribute("token").toString();
	}
	
	@GetMapping("/member")
	public Member getMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if(member != null) {
			return member;
		}
		System.out.println(member);
		return null;
	}
	
	@GetMapping("/logout")
	public void logout(HttpSession session, HttpServletResponse response) throws IOException {
		session.invalidate();
		response.sendRedirect("http://localhost:8081");
	}

	@GetMapping("/login")
	public void login(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		HttpSession session = request.getSession();
		
		Member member = new Member();
		System.out.println("[GET /oauth/login] Code: " + code);
		JsonNode jsonNode = oAuth2Service.login(code);

		System.out.println("[GET /oauth/login] JsonNode: " + jsonNode);
		String token = jsonNode.get("access_token").toString();

		System.out.println("[GET /oauth/login] Token: " + token);
		session.setAttribute("token", token);

		response.sendRedirect("http://localhost:8081");

		jsonNode = oAuth2Service.getUser(token);
		String id = jsonNode.get("id").toString();

		JsonNode kakaoAccount = jsonNode.get("kakao_account");
		String email = kakaoAccount.get("email").toString();
		String birthday = kakaoAccount.get("birthday").toString();
		String gender = kakaoAccount.get("gender").toString();

		member.setId(id);
		member.setEmail(email);
		member.setBirthday(birthday);
		member.setGender(gender);
		session.setAttribute("member", member);

		System.out.println("[GET /oauth/login] UserInfo: " + member.toString());
	}
}
