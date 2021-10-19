package com.hyperledjo.surveyther.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeyConfig {

	@Value("${payment.api.key}")
	private String paymentApiKey;

	@Value("${payment.secret.key}")
	private String paymentSecretKey;

	@Value("${rest.api.key}")
	private String restApiKey;

	@Value("${client.secret.key}")
	private String clientSecretKey;

	@Value("${app.admin.key}")
	private String appAdminKey;

	// Key를 필요로 하는 곳에서 전부 사용하기 때문에 중복 생성을 막기 위해 싱글톤으로 구현
//	private static KeyConfig instance = new KeyConfig();

//	private KeyConfig() {
//		
//	}

	public String getPaymentApiKey() {
		return paymentApiKey;
	}

	public String getPaymentSecretKey() {
		return paymentSecretKey;
	}

	public String getAppAdminKey() {
		return appAdminKey;
	}

	public String getClientSecretKey() {
		return clientSecretKey;
	}

	public String getRestApiKey() {
		return restApiKey;
	}

//	public static KeyConfig getInstance() {
//		if(instance == null) {
//			instance = new KeyConfig();
//		}
//		
//		return instance;
//	}
}
