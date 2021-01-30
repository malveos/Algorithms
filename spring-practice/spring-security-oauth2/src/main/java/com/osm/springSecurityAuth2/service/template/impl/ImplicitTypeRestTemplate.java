package com.osm.springSecurityAuth2.service.template.impl;

import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitResourceDetails;

import com.osm.springSecurityAuth2.service.template.RestTemplateCreator;
import com.osm.springSecurityAuth2.util.Constants;

public class ImplicitTypeRestTemplate extends RestTemplateCreator{

	@Override
	public OAuth2ProtectedResourceDetails getResourceDetails() {
		resourceDetails = new ImplicitResourceDetails();
		setCommonParameters();

		resourceDetails.setAccessTokenUri(authorizeUrl);
		((ImplicitResourceDetails) resourceDetails).setUserAuthorizationUri(authorizeUrl);
		((ImplicitResourceDetails) resourceDetails).setPreEstablishedRedirectUri(Constants.REDIRECT_URI);
		((ImplicitResourceDetails) resourceDetails).setUseCurrentUri(false);
		return resourceDetails;
	}

}
