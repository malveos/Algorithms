package com.osm.springSecurityAuth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.osm.springSecurityAuth2.service.IUserService;

@Component("customUserdetails")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("userservice")
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
			throw new IllegalArgumentException("Username is null or empty");
		}
		return userService.getUserFromUserName(username);
	}

}
