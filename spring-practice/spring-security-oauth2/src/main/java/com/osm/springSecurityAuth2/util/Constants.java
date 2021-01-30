package com.osm.springSecurityAuth2.util;

public class Constants {

	public static final String GRANTTYPE_PASSWORD = "password";
	public static final String GRANTTYPE_REFRESH_TOKEN = "refresh_token";
	public static final String GRANTTYPE_AUTHORIZATION_CODE = "authorization_code";
	public static final String GRANTTYPE_IMPLICIT = "implicit";
	public static final String GRANTTYPE_CLIENT_CREDENTIALS = "client_credentials";

	public static final String CLIENT_ID = "client";
	public static final String CLIENT_SECRET = "client";
	public static final String REDIRECT_URI = "http://www.google.com";
	public static final String[] SCOPES = { "read", "write" };
	public static final String USER_AUTHORITY = "USER";
	public static final String[] ALL_GRANTTYPES = { GRANTTYPE_PASSWORD, GRANTTYPE_REFRESH_TOKEN,
			GRANTTYPE_AUTHORIZATION_CODE, GRANTTYPE_IMPLICIT, GRANTTYPE_CLIENT_CREDENTIALS };

}
