package com.hyperledjo.surveyther.OAuth2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperledjo.surveyther.Config.KeyConfig;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OAuth2Login {

	private KeyConfig keyConfig;

	public OAuth2Login(KeyConfig keyConfig) {
		this.keyConfig = keyConfig;
	}

	public JsonNode getUser(String token) {

		final String requestURL = "https://kapi.kakao.com/v2/user/me";
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(requestURL);

		post.addHeader("Authorization", "Bearer " + token);

		JsonNode jsonNode = null;

		try {
			final HttpResponse response = client.execute(post);
			ObjectMapper mapper = new ObjectMapper();
			jsonNode = mapper.readTree(response.getEntity().getContent());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("get User node: " + jsonNode.toPrettyString());
		}
		return jsonNode;
	}

	public JsonNode getToken(String code) {
		final String requestURL = "https://kauth.kakao.com/oauth/token";
		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		System.out.println(keyConfig.getRestApiKey());
		postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		postParams.add(new BasicNameValuePair("client_id", keyConfig.getRestApiKey()));
		postParams.add(new BasicNameValuePair("redirect_uri",
				"http://localhost:8082/oauth2/login"));
//				"http://ec2-3-36-111-77.ap-northeast-2.compute.amazonaws.com:8082/oauth2/login"));
		postParams.add(new BasicNameValuePair("code", code));
		postParams.add(new BasicNameValuePair("client_secret", keyConfig.getClientSecretKey()));

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(requestURL);

		JsonNode jsonNode = null;

		try {
			post.setEntity(new UrlEncodedFormEntity(postParams));
			final HttpResponse response = client.execute(post);
			ObjectMapper mapper = new ObjectMapper();
			jsonNode = mapper.readTree(response.getEntity().getContent());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return jsonNode;
	}
}
