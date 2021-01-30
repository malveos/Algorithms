package com.osm.springSecurityAuth1.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.osm.springSecurityAuth1.config.RestTemplateFactory;
import com.osm.springSecurityAuth1.data.model.Users;
import com.osm.springSecurityAuth1.service.UserService;

@RestController
@RequestMapping("/api")
public class EntryController {

	@Autowired
	private RestTemplateFactory resFactory;

	@Autowired
	@Qualifier("userService")
	private UserService userservice;
	
	@Autowired
	private PasswordEncoder pe;

	@GetMapping("/get")
	public String firstMethods() {
		return pe.encode("password");
	}

	@GetMapping("/get/users")
	public String getUsers() {
		return userservice.getAllUsersAsString();
	}

	@PostMapping("/insert/user")
	public String Insertuser(@RequestBody Users user) {
		return userservice.addUser(user);
	}

	@GetMapping("/test/get")
	public String testGETByResttemplate() throws RestClientException, Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> res = resFactory.getObject().exchange("http://localhost:8080/api/get", HttpMethod.GET,
				entity, String.class);
		if (res.getStatusCode().equals(HttpStatus.OK)) {
			return "Called with RestTemplate : " + res.getBody();
		}
		return "Failed: statusCode:->" + res.getStatusCodeValue();
	}
}
