package com.hyperledjo.surveyther.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hyperledjo.surveyther.Service.OAuth2Service;

@RestController
@RequestMapping("/oauth")
public class OAuth2Controller {

	private OAuth2Service oAuth2Service;

	public OAuth2Controller(OAuth2Service oAuth2Service) {
		this.oAuth2Service = oAuth2Service;
	}

//	@GetMapping("/logout")
//	public boolean kakaoLogout(HttpSession session) {
//		OAuth2Login oauthKakao = new OAuth2Login();
//		
//		JsonNode jsonNode = oauthKakao.logout(session.getAttribute("token").toString());
//
//		if(!(jsonNode.get("id").isEmpty())) {
//			System.out.println(jsonNode.get("id"));
//			session.invalidate();
//			return true;
//		}
//		
//		return false;
//	}

	@GetMapping("/logout")
	public void logout(HttpSession session, HttpServletResponse response) throws IOException {
		
	}
	
	@GetMapping("/login")
	public void login(@RequestParam("code") String code, HttpSession session, HttpServletResponse response) throws IOException {
		System.out.println("[GET /oauth/login] Code: " + code);
		JsonNode jsonNode = oAuth2Service.login(code);
		System.out.println("[GET /oauth/login] JsonNode: " + jsonNode);
		String token = jsonNode.get("access_token").toString();
		System.out.println("[GET /oauth/login] Token: " + token);
		session.setAttribute("token", token);
		response.sendRedirect("http://localhost:8081");
	}
}
