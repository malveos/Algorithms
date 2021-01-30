package com.osm.springSecurityAuth2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.osm.springSecurityAuth2.util.Constants;

/**
 * Clients can be configured as inmemory or using database
 * 
 * 
 * 
 * @author omalve
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private Environment env;
	private AuthenticationManager authenticationManager;
	private CustomUserDetailsService userDetailsService;
	private PasswordEncoder passencoder;

	@Autowired
	public AuthorizationServerConfigurer(DataSource dataSource, Environment env,
			@Qualifier("customUserdetails") CustomUserDetailsService userDetailsService,
			PasswordEncoder passencoder,
			AuthenticationManager authenticationManager) {
		this.dataSource = dataSource;
		this.env = env;
		this.passencoder = passencoder;
		this.userDetailsService = userDetailsService;
		this.authenticationManager = authenticationManager;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.pathMapping("/oauth/token", "/oauth/generatetoken")
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService)
			.tokenStore(tokenStore())
			.reuseRefreshTokens(false)
			.accessTokenConverter(accessTokenConverter());
	}

	/**
	 * It defines security for the oauth server that what is accessable 
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
		.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(Constants.CLIENT_ID)
		.secret(passencoder.encode(Constants.CLIENT_SECRET))
		.authorizedGrantTypes(Constants.ALL_GRANTTYPES)
		.scopes(Constants.SCOPES)
		.authorities(Constants.USER_AUTHORITY)
		.accessTokenValiditySeconds(120)
		.redirectUris(Constants.REDIRECT_URI) // for authorization_code and implicit grant
		.autoApprove(true);

		//clients.jdbc(dataSource);
	}

	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	public JwtAccessTokenConverter accessTokenConverter() {
		String publicKey = env.getProperty("security.oauth2.resource.jwt.key-value");
		JwtAccessTokenConverter converter = new CustomTokenConverter();
		converter.setSigningKey(env.getProperty("privateKey"));
		converter.setVerifier(new RsaVerifier(publicKey));
		return converter;
	}

	@Configuration
	public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

		private Environment env = null;

		@Autowired
		public ResourceServerConfigurer(Environment env) {
			this.env = env;
		}

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.resourceId(env.getProperty("resourceId"));
		}
	}
}
