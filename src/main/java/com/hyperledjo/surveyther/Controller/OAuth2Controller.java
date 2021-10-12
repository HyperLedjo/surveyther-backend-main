package com.hyperledjo.surveyther.Controller;

import java.io.IOException;

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
	private HttpSession httpSession;

	public OAuth2Controller(OAuth2Service oAuth2Service, HttpSession httpSession) {
		this.oAuth2Service = oAuth2Service;
		this.httpSession = httpSession;
	}

	/*
	 * Session에 저장되어 있는 카카오톡 유저 정보를 조회(DB에서 조회X)
	 */
	@GetMapping("/me")
	public Member getMember() {
		Member member = (Member) httpSession.getAttribute("member");
		if (member != null) {
			return member;
		}
		return null;
	}

	/*
	 * 카카오톡 로그아웃 서비스 Session을 만료시키고, 메인 페이지로 리다이렉트
	 */
	@GetMapping("/logout")
	public void logout(HttpServletResponse response) throws IOException {
		httpSession.invalidate();
		response.sendRedirect("http://localhost:8081");
	}

	/*
	 * 카카오톡 로그인 서비스 카카오톡 로그인 완료시 리다이렉트 되는 REST API로 발급된 인가 코드를 인자로 전달 인가 코드를 통해 접근
	 * 토큰과 리프레시 토큰을 발급 발급된 접근 토큰으로 카카오톡 유저 정보를 획득하고 Session에 등록
	 */
	@GetMapping("/login")
	public void login(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
		Member member = new Member();
		
		JsonNode jsonNode = oAuth2Service.login(code);
		String token = jsonNode.get("access_token").toString();

		jsonNode = oAuth2Service.getUser(token);
		String id = jsonNode.get("id").toString();
		
		JsonNode kakaoAccount = jsonNode.get("kakao_account");
		String email = kakaoAccount.get("email").asText();
		String birthday = kakaoAccount.get("birthday").asText();
		String gender = kakaoAccount.get("gender").asText();

		member.setId(id);
		member.setEmail(email);
		member.setBirthDay(birthday);
		member.setGender(gender);
		httpSession.setAttribute("member", member);

		response.sendRedirect("http://localhost:8081");
	}
}
