package com.osm.springSecurityAuth1.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.osm.springSecurityAuth1.data.model.Authorities;
import com.osm.springSecurityAuth1.data.model.Users;
import com.osm.springSecurityAuth1.data.repos.AuthoritiesRepository;
import com.osm.springSecurityAuth1.data.repos.UsersRepository;

@Service
public class MyUserDetailsManager implements UserDetailsManager {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private AuthoritiesRepository authosRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found :" + username));
		List<Authorities> autorities = authosRepository.findByUsername(username);
		List<GrantedAuthority> roles = new ArrayList<>();
		if (!CollectionUtils.isEmpty(autorities)) {
			List<String> role_names = autorities.stream().map(a -> a.getAuthority()).collect(Collectors.toList());
			for (String role : role_names) {
				roles.add(new SimpleGrantedAuthority(role));
			}
		}
		return new MyUser(user.getUsername(), user.getPassword(), roles);
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		return null != userRepository.findById(username).orElse(null);
	}

}
