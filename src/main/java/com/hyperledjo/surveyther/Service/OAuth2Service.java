package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hyperledjo.surveyther.OAuth2.OAuth2Login;

@Service
public class OAuth2Service {
	
	private OAuth2Login oAuth2Login;

	public OAuth2Service(OAuth2Login oAuth2Login) {
		this.oAuth2Login = oAuth2Login;
	}
	
	public JsonNode login(String code) {
		JsonNode jsonNode = oAuth2Login.getToken(code);
		return jsonNode;
	}
	
	public JsonNode getUser(String token) {
		JsonNode jsonNode = oAuth2Login.getUser(token);
		return jsonNode;
	}
}
