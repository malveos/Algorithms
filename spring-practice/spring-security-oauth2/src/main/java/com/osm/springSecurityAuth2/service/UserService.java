package com.osm.springSecurityAuth2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.osm.springSecurityAuth2.data.model.Authority;
import com.osm.springSecurityAuth2.data.model.User;
import com.osm.springSecurityAuth2.data.repository.CustomRolesRepository;
import com.osm.springSecurityAuth2.data.repository.CustomUserRepository;
import com.osm.springSecurityAuth2.dto.CustomUserModel;

@Service("userservice")
public class UserService implements IUserService {

	@Autowired
	private CustomUserRepository userRepository;

	@Autowired
	private CustomRolesRepository authorityRepository;

	@Override
	public CustomUserModel getUserFromUserName(String username) {
		User user = userRepository.findByUsername(username);
		if (null == user) {
			throw new IllegalArgumentException("Invalid username");
		}
		List<Authority> roles = authorityRepository.findByUserId(user.getUser_Id());
		List<GrantedAuthority> authorities = new ArrayList<>();
		if (!CollectionUtils.isEmpty(roles)) {
			List<String> role_names = roles.stream().map(a -> a.getAuthority()).collect(Collectors.toList());
			for (String role : role_names) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
		}
		return new CustomUserModel(username, user.getPassword(), user.getDashboard(), authorities);
	}

}
