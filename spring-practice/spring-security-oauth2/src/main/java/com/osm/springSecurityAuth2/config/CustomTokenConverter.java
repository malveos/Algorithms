package com.osm.springSecurityAuth2.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.osm.springSecurityAuth2.dto.CustomUserModel;
import com.osm.springSecurityAuth2.util.Constants;

public class CustomTokenConverter extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		OAuth2Request oauthReq = authentication.getOAuth2Request();
		DefaultOAuth2AccessToken customAccessToken = (DefaultOAuth2AccessToken) accessToken;
		Map<String, Object> infoMap = new LinkedHashMap<>();
		if (Constants.GRANTTYPE_PASSWORD.equalsIgnoreCase(oauthReq.getGrantType())) {
			infoMap.put("Grant Type", Constants.GRANTTYPE_PASSWORD);
			customAccessToken.setAdditionalInformation(
					getAdditionalInformationMap((CustomUserModel) authentication.getPrincipal(), infoMap));
		} else if (Constants.GRANTTYPE_CLIENT_CREDENTIALS.equalsIgnoreCase(oauthReq.getGrantType())) {
			infoMap.put("Grant Type", Constants.GRANTTYPE_CLIENT_CREDENTIALS);
		} else if (Constants.GRANTTYPE_AUTHORIZATION_CODE.equalsIgnoreCase(oauthReq.getGrantType())) {
			infoMap.put("Grant Type", Constants.GRANTTYPE_AUTHORIZATION_CODE);
		} else if (Constants.GRANTTYPE_IMPLICIT.equalsIgnoreCase(oauthReq.getGrantType())) {
			infoMap.put("Grant Type", Constants.GRANTTYPE_IMPLICIT);
		}
		return super.enhance(accessToken, authentication);
	}

	private Map<String, Object> getAdditionalInformationMap(CustomUserModel user, Map<String, Object> infoMap) {
		infoMap.put("username", user.getUsername());
		infoMap.put("dashboard", user.getDashboard());
		infoMap.put("authorities", user.getAuthorities());
		return infoMap;
	}
}
