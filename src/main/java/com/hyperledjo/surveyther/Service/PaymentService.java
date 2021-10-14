package com.hyperledjo.surveyther.Service;

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
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyperledjo.surveyther.Config.KeyConfig;
import com.hyperledjo.surveyther.Config.UrlConfig;
import com.hyperledjo.surveyther.DTO.PaymentRequest;

@Service
public class PaymentService {

	private KeyConfig keyConfig;
	private UrlConfig urlConfig;

	public PaymentService(KeyConfig keyConfig, UrlConfig urlConfig) {
		this.keyConfig = keyConfig;
		this.urlConfig = urlConfig;
	}

	public JsonNode approve(PaymentRequest paymentRequest) {
		JsonNode jsonNode = null;

		final String requestURL = urlConfig.getPaymentApproveUrl();

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(requestURL);
		post.addHeader("Authorization", "KakaoAK " + keyConfig.getAppAdminKey());

		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		postParams.add(new BasicNameValuePair("cid", "TC0ONETME"));
		postParams.add(new BasicNameValuePair("tid", paymentRequest.getTid()));
		postParams.add(new BasicNameValuePair("partner_order_id", "1111"));
		postParams.add(new BasicNameValuePair("partner_user_id", "test"));
		postParams.add(new BasicNameValuePair("pg_token", paymentRequest.getPgToken()));
		postParams.add(new BasicNameValuePair("total_amount", paymentRequest.getTotalAmount()));

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
		}

		return jsonNode;
	}

	public JsonNode payment() {
		final String requestURL = urlConfig.getPaymentReadyUrl();

		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		postParams.add(new BasicNameValuePair("cid", "TC0ONETME"));
		postParams.add(new BasicNameValuePair("partner_order_id", "1111"));
		postParams.add(new BasicNameValuePair("partner_user_id", "test"));
		postParams.add(new BasicNameValuePair("item_name", "survey"));
		postParams.add(new BasicNameValuePair("quantity", "1"));
		postParams.add(new BasicNameValuePair("total_amount", "10000"));
		postParams.add(new BasicNameValuePair("tax_free_amount", "200"));
		postParams.add(new BasicNameValuePair("approval_url", urlConfig.getBackendUrl() + "/payment/success"));
		postParams.add(new BasicNameValuePair("cancel_url", urlConfig.getBackendUrl() + "/payment/fail"));
		postParams.add(new BasicNameValuePair("fail_url", urlConfig.getBackendUrl() + "/payment/cancel"));

		final HttpClient client = HttpClientBuilder.create().build();
		final HttpPost post = new HttpPost(requestURL);
		post.addHeader("Authorization", "KakaoAK " + keyConfig.getAppAdminKey());

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
		}

		return jsonNode;
	}

}
