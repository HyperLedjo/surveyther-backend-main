package com.hyperledjo.surveyther.Service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	/*
	 * private KeyConfig keyConfig;
	 * 
	 * public PaymentService(KeyConfig keyConfig) { this.keyConfig = keyConfig; }
	 * 
	 * public JsonNode payment() { final String requestURL =
	 * "https://kapi.kakao.com/v1/payment/ready";
	 * 
	 * final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
	 * postParams.add(new BasicNameValuePair("cid", "TC0ONETIME"));
	 * postParams.add(new BasicNameValuePair("partner_order_id", "1111"));
	 * postParams.add(new BasicNameValuePair("partner_user_id", "test"));
	 * postParams.add(new BasicNameValuePair("item_name", "survey"));
	 * postParams.add(new BasicNameValuePair("quantity", "1")); postParams.add(new
	 * BasicNameValuePair("total_amount", "10000")); postParams.add(new
	 * BasicNameValuePair("tax_free_amount", "2000")); postParams.add(new
	 * BasicNameValuePair("approval_url", "https://developers.kakao.com/success"));
	 * postParams.add(new BasicNameValuePair("cancel_url",
	 * "https://developers.kakao.com/fail")); postParams.add(new
	 * BasicNameValuePair("fail_url", "https://developers.kakao.com/cancel"));
	 * 
	 * final HttpClient client = HttpClientBuilder.create().build(); final HttpPost
	 * post = new HttpPost(requestURL); post.addHeader("Authorization", "KakaoAK " +
	 * keyConfig.getAppAdminKey());
	 * 
	 * JsonNode jsonNode = null;
	 * 
	 * try { post.setEntity(new UrlEncodedFormEntity(postParams)); final
	 * HttpResponse response = client.execute(post); ObjectMapper mapper = new
	 * ObjectMapper(); jsonNode =
	 * mapper.readTree(response.getEntity().getContent()); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); } catch
	 * (ClientProtocolException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); } finally {
	 * 
	 * } return jsonNode; }
	 */

}
