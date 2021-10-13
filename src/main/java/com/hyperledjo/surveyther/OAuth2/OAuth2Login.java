package com.hyperledjo.surveyther.OAuth2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperledjo.surveyther.Config.KeyConfig;
import com.hyperledjo.surveyther.Config.UrlConfig;

@Component
public class OAuth2Login {

	private KeyConfig keyConfig;
	private UrlConfig urlConfig;

	public OAuth2Login(KeyConfig keyConfig, UrlConfig urlConfig) {
		this.keyConfig = keyConfig;
		this.urlConfig = urlConfig;
	}

	public JsonNode getUser(String token) {

		final String requestURL = urlConfig.getUserMeUrl();
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

		}
		return jsonNode;
	}

	public JsonNode getToken(String code) {
		final String requestURL = urlConfig.getOauthTokenUrl();
		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		System.out.println(keyConfig.getRestApiKey());
		postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		postParams.add(new BasicNameValuePair("client_id", keyConfig.getRestApiKey()));
		// postParams.add(new BasicNameValuePair("redirect_uri",
		// "http://localhost:8082/oauth2/login"));
		postParams.add(new BasicNameValuePair("redirect_uri", urlConfig.getBackendUrl() + "/oauth2/login"));
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
