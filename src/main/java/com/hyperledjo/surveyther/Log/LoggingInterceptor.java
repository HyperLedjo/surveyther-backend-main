package com.hyperledjo.surveyther.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LoggingInterceptor extends HandlerInterceptorAdapter {
	private final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String HTTP_METHOD = "GET";
		if (request.getMethod().equals("POST"))
			HTTP_METHOD = "POST";
		if (request.getClass().getName().contains("SecurityContextHolderAwareRequestWrapper"))
			return;
		final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;
		final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper) response;
		if (cachingRequest.getContentType() != null && cachingRequest.getContentType().contains("application/json")) {
			if (cachingRequest.getContentAsByteArray() != null && cachingRequest.getContentAsByteArray().length != 0) {
				log.info("[{}] Request Body : {}", HTTP_METHOD,
						objectMapper.readTree(cachingRequest.getContentAsByteArray()));
			}
		}
		if (cachingResponse.getContentType() != null && cachingResponse.getContentType().contains("application/json")) {
			if (cachingResponse.getContentAsByteArray() != null
					&& cachingResponse.getContentAsByteArray().length != 0) {
				log.info("[{}] Response Body : {}", HTTP_METHOD,
						objectMapper.readTree(cachingResponse.getContentAsByteArray()));
			}
		}
	}
}