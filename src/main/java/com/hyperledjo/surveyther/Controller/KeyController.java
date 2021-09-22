package com.hyperledjo.surveyther.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyperledjo.surveyther.Config.KeyConfig;

@RestController
@RequestMapping("/api")
public class KeyController {
	
	private KeyConfig keyConfig;
	
	public KeyController(KeyConfig keyConfig) {
		this.keyConfig = keyConfig;
	}
	
	@GetMapping("/rest/key")
	public String getKey() {	
		return keyConfig.getRestApiKey();
	}
}
