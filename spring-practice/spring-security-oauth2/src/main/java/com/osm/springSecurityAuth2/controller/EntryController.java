package com.osm.springSecurityAuth2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.osm.springSecurityAuth2.config.TemplateConfig;
import com.osm.springSecurityAuth2.util.Constants;

@RestController
public class EntryController {

	@Autowired
	private TemplateConfig templateConfig;

	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/api/testcall")
	public ResponseEntity<String> methodForTest(@RequestParam String body) {
		return new ResponseEntity<String>("Method accessed successfully, body: " + body, HttpStatus.OK);
	}

	@GetMapping("/test/authCode")
	public ResponseEntity<String> methodAuthCodeGrant() {
		String response = makeMethodCallAndReturn(templateConfig.getTemplate(Constants.GRANTTYPE_AUTHORIZATION_CODE), "authcode grant.");
		return new ResponseEntity<String>("Response: " + response, HttpStatus.OK);
	}

	@GetMapping("/test/implicit")
	public ResponseEntity<String> methodImplicitGrant() {
		OAuth2RestOperations template = templateConfig.getTemplate(Constants.GRANTTYPE_IMPLICIT);
		String response = makeMethodCallAndReturn(template, "implicit grant.");
		return new ResponseEntity<String>("Response: " + response, HttpStatus.OK);
	}

	@GetMapping("/test/clientCred")
	public ResponseEntity<String> methodClient_CredGrant() {
		String response = makeMethodCallAndReturn(templateConfig.getTemplate(Constants.GRANTTYPE_CLIENT_CREDENTIALS), "client_credentials grant.");
		return new ResponseEntity<String>("Response: " + response, HttpStatus.OK);
	}

	@GetMapping("/test/password")
	public ResponseEntity<String> methodPasswordGrant() {
		String response = makeMethodCallAndReturn(templateConfig.getTemplate(Constants.GRANTTYPE_PASSWORD), "password grant.");
		return new ResponseEntity<String>("Response: " + response, HttpStatus.OK);
	}

	@GetMapping("/test/token/implicit")
	public ResponseEntity<String> methodGetToken() {
		RestOperations restTemplate = new RestTemplate();//.getTemplate(Constants.GRANTTYPE_PASSWORD);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/oauth/authorize")
				.queryParam("response_type", "token")
				.queryParam("client_id", "client")
				.queryParam("client_secret", "client")
				.queryParam("redirect_uri", "http://www.google.com");
		
		//http://localhost:8080/oauth/authorize?response_type=token&client_id=client&redirect_uri=http://www.google.com	
		String response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, String.class).getBody();
		return new ResponseEntity<String>("Response: " + response, HttpStatus.OK);
	}

	public String makeMethodCallAndReturn(OAuth2RestOperations restTemplate, String message) {
		return restTemplate.exchange(UriComponentsBuilder.fromHttpUrl("http://localhost:8080/api/testcall?body={body}").build().encode().toUriString(), HttpMethod.GET, null, String.class,
				getUriParameters(message)).getBody();
	}

	public Map<String, Object> getUriParameters(String message) {
		Map<String, Object> vars = new HashMap<>();
		vars.put("body", "Accessing authorised call by " + message);
		return vars;
	}
}
