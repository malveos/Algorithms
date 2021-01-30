package com.osm.springSecurityAuth2.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.google.common.base.Predicates;
import com.osm.springSecurityAuth2.util.Constants;

import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

@Configuration
public class SwaggerConfigurer {
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String DEFAULT_INCLUDE_PATTERN = "/.*";

	String AUTH_SERVER_GENERATE_TOKEN = "http://localhost:8080/oauth/generatetoken";

	@Bean
	public Docket OauthApiDoc() {
		final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = Set.of("application/json");

		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(securityScheme()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.osm.springSecurityAuth2.controller"))
				.paths(Predicates.not(PathSelectors.regex("/error")))
				.build()
				.apiInfo(apiInfo())
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}

    private SecurityContext securityContext() {
   	return SecurityContext.builder()
				.securityReferences(Arrays.asList(new SecurityReference("spring_oauth", 
						Collections.emptyList().toArray(new AuthorizationScope[0]))))
				.forPaths(PathSelectors.ant("/api**"))
				.build();
	}

	private SecurityScheme securityScheme() {		
		GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER_GENERATE_TOKEN);
		SecurityScheme oauth = new OAuthBuilder()
				.name("spring_oauth")
				.grantTypes(Arrays.asList(grantType))
				.build();
		return oauth;
	}

	// default configuration, prepopulated fields
	@Bean
	@Profile("!prod")
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder()
				.clientId(Constants.CLIENT_ID)
				.clientSecret(Constants.CLIENT_SECRET)
				.scopeSeparator(" ")
				.useBasicAuthenticationWithAccessCodeGrant(true)
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"REST API for Oauth service",
				"This service is used to generate Access and Refresh tokens for Quinstreet Exchange Apps",
				"API TOS",
				"Terms of Service",
				new Contact("QMP Tech Team", "www.quinstreet.com", "qmp_ui_team@quinstreet.com"),
				"License of API",
				"API License URL",
				Collections.emptyList());
	}

}