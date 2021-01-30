package com.osm.springSecurityAuth1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * Inmemory Authentication : Using AuthenticationManagerBuilder or return InMemoryUserDetailsManager(userDetails)
 * DAO: UserDetailsService can have implementation By DB based.
 * using datasource: Need table users(username, password), authorities(username, authority-USER, ADMIN)
 * 
 * inMemory work with any of two
 * @author omalve
 *
 */
@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private MyUserDetailsManager userDetailsManager;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(getUserDetails())
		.and()
		.jdbcAuthentication().dataSource(dataSource)
		.and()
		.inMemoryAuthentication()
			.withUser("malveos").password(getPassswordEncoder().encode("password")).roles("USER")
		;
	}

	@Bean
	public PasswordEncoder getPassswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public UserDetailsService getUserDetails() {
		return userDetailsManager;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/api/get/users", "/api/insert/user");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .anyRequest().authenticated()
		.and().httpBasic()
		.and().formLogin()//.loginPage("/api/login")
			.permitAll()
//		.and().logout().logoutUrl("/api/logout")
//			.logoutSuccessUrl("/api/index")
//			//.logoutSuccessHandler()
//			.invalidateHttpSession(true)
//			//.addLogoutHandler()
//			.deleteCookies()
        .and().csrf().disable();
		http.headers().frameOptions().disable();
		http.cors().disable();
	}
}
