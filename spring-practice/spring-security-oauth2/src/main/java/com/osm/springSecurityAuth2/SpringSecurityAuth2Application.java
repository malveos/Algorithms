package com.osm.springSecurityAuth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SpringSecurityAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuth2Application.class, args);
	}

}
