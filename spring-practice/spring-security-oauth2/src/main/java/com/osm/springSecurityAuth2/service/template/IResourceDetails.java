package com.osm.springSecurityAuth2.service.template;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

public interface IResourceDetails {

	OAuth2ProtectedResourceDetails getResourceDetails();

	OAuth2RestTemplate getTemplate();
}
