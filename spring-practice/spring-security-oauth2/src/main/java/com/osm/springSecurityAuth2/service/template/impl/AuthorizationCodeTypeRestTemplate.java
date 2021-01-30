package com.osm.springSecurityAuth2.service.template.impl;

import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

import com.osm.springSecurityAuth2.service.template.RestTemplateCreator;
import com.osm.springSecurityAuth2.util.Constants;

public class AuthorizationCodeTypeRestTemplate extends RestTemplateCreator{

	@Override
	public OAuth2ProtectedResourceDetails getResourceDetails() {
		resourceDetails = new AuthorizationCodeResourceDetails();
		setCommonParameters();

		resourceDetails.setAccessTokenUri(tokenUrl);
		((AuthorizationCodeResourceDetails) resourceDetails).setUserAuthorizationUri(authorizeUrl);
		((AuthorizationCodeResourceDetails) resourceDetails).setPreEstablishedRedirectUri(Constants.REDIRECT_URI);
		((AuthorizationCodeResourceDetails) resourceDetails).setUseCurrentUri(false);
		return resourceDetails;
	}

}
