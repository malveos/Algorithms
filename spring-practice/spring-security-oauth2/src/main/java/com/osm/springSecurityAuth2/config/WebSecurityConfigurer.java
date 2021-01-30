package com.osm.springSecurityAuth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	private final String[] MATCH_URIS = {
			"/v2/api-docs", 
			"/configuration/ui",
			"/configuration/security",
			"/swagger-resources/**", 
			"/swagger-ui.html**",
			"/webjars/**",
			"/h2-console/**",
			//"/oauth/authorize",
			"/test/**",
			"/v2/inquiry/email",
			"favicon.ico"
	};

	@Override
	@Bean
	@Primary
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
			.withUser("malveos").password(passwordEncoder().encode("password")).roles("USER")
		;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(MATCH_URIS);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http//.csrf().ignoringAntMatchers("/oauth/authorize")
			//.and()
			.authorizeRequests().antMatchers(MATCH_URIS)
				.permitAll().anyRequest().authenticated()
			.and().httpBasic()
			.and().csrf().disable();
		http.headers().frameOptions().disable();
		http.cors().disable();
	}

}
