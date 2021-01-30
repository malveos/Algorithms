package com.osm.springSecurityAuth2.service.template.impl;

import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import com.osm.springSecurityAuth2.service.template.RestTemplateCreator;

public class ClientCredentialsTypeRestTemplate extends RestTemplateCreator {

	@Override
	public OAuth2ProtectedResourceDetails getResourceDetails() {
		resourceDetails = new ClientCredentialsResourceDetails();
		setCommonParameters();
		resourceDetails.setAccessTokenUri(tokenUrl);
		return resourceDetails;
	}

}
