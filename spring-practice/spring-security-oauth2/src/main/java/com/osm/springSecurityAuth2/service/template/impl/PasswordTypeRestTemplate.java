package com.osm.springSecurityAuth2.service.template.impl;

import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import com.osm.springSecurityAuth2.service.template.RestTemplateCreator;

public class PasswordTypeRestTemplate extends RestTemplateCreator {

	@Override
	public OAuth2ProtectedResourceDetails getResourceDetails() {
		resourceDetails = new ResourceOwnerPasswordResourceDetails();
		setCommonParameters();

		resourceDetails.setAccessTokenUri(tokenUrl);
		((ResourceOwnerPasswordResourceDetails) resourceDetails).setUsername("omkar");
		((ResourceOwnerPasswordResourceDetails) resourceDetails).setPassword("password");
		return resourceDetails;
	}

}
