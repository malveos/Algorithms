package com.osm.springSecurityAuth2.service.template;

import java.util.Arrays;

import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;

import com.osm.springSecurityAuth2.util.Constants;

public abstract class RestTemplateCreator implements IResourceDetails {

	protected String authorizeUrl = "http://localhost:8080/oauth/authorize";

	protected String tokenUrl = "http://localhost:8080/oauth/generatetoken";

	protected BaseOAuth2ProtectedResourceDetails resourceDetails;

	public BaseOAuth2ProtectedResourceDetails setCommonParameters() {
		resourceDetails.setClientId(Constants.CLIENT_ID);
		resourceDetails.setClientSecret(Constants.CLIENT_SECRET);
		resourceDetails.setScope(Arrays.asList(Constants.SCOPES));
		return resourceDetails;
	}

	@Override
	public OAuth2RestTemplate getTemplate() {
		AccessTokenRequest atr = new DefaultAccessTokenRequest();
		//OAuth2RestTemplate template = new OAuth2RestTemplate(getResourceDetails(), new DefaultOAuth2ClientContext(atr));
		return new OAuth2RestTemplate(getResourceDetails(), new DefaultOAuth2ClientContext(atr));
	}
}
