package com.osm.springSecurityAuth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import com.osm.springSecurityAuth2.service.template.RestTemplateCreator;
import com.osm.springSecurityAuth2.service.template.impl.AuthorizationCodeTypeRestTemplate;
import com.osm.springSecurityAuth2.service.template.impl.ClientCredentialsTypeRestTemplate;
import com.osm.springSecurityAuth2.service.template.impl.ImplicitTypeRestTemplate;
import com.osm.springSecurityAuth2.service.template.impl.PasswordTypeRestTemplate;
import com.osm.springSecurityAuth2.util.Constants;

@Configuration
@EnableOAuth2Client
public class TemplateConfig {

	public OAuth2RestOperations getTemplate(String granttype) {
		RestTemplateCreator template = null;
		if (Constants.GRANTTYPE_PASSWORD.equals(granttype)) {
			template = new PasswordTypeRestTemplate();
		} else if (Constants.GRANTTYPE_CLIENT_CREDENTIALS.equals(granttype)) {
			template = new ClientCredentialsTypeRestTemplate();
		} else if (Constants.GRANTTYPE_IMPLICIT.equals(granttype)) {
			template = new ImplicitTypeRestTemplate();
		} else if (Constants.GRANTTYPE_AUTHORIZATION_CODE.equals(granttype)) {
			template = new AuthorizationCodeTypeRestTemplate();
		}
		return template.getTemplate();
	}

}
