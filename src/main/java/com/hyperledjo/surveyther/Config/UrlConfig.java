package com.hyperledjo.surveyther.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlConfig {
	@Value("{frontend.url}")
	private String frontendUrl;

	@Value("{backend.url}")
	private String backendUrl;

	@Value("{oauth.token.url}")
	private String oauthTokenUrl;

	@Value("{user.me.url}")
	private String userMeUrl;

	@Value("{user.logout.url}")
	private String userLogoutUrl;

	public String getFrontendUrl() {
		return frontendUrl;
	}

	public String getBackendUrl() {
		return backendUrl;
	}

	public String getOauthTokenUrl() {
		return oauthTokenUrl;
	}

	public String getUserMeUrl() {
		return userMeUrl;
	}

	public String getUserLogoutUrl() {
		return userLogoutUrl;
	}
}
