package com.hyperledjo.surveyther.OAuth2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OAuth2Logout {

	public JsonNode logout(String code) {
		JsonNode jsonNode = null;

		final String requestURL = "https://kapi.kakao.com/v1/user/logout";
		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(requestURL);

		post.addHeader("Authorization", "Bearer " + code);

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
}
