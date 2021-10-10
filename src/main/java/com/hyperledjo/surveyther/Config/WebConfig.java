package com.hyperledjo.surveyther.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hyperledjo.surveyther.Log.LoggingInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	final LoggingInterceptor loggingInterceptor = new LoggingInterceptor();

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.addCorsMappings(registry);
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggingInterceptor).addPathPatterns("/**").excludePathPatterns("/vendor/**", "/css/*",
				"/img/*");
	}
}
