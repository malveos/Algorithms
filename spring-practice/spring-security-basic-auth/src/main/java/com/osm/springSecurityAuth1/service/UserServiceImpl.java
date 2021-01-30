package com.osm.springSecurityAuth1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.osm.springSecurityAuth1.data.model.Users;
import com.osm.springSecurityAuth1.data.repos.UsersRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String getAllUsersAsString() {
		Long count = userRepository.count();
		StringBuilder res = new StringBuilder("");
		userRepository.findAll().forEach(u -> 
			res.append("[username:").append(u.getUsername())
			.append(", password:").append(u.getPassword())
			.append("]\n"));
		return "Count: " + count + ",\nUsers: " + res.toString();
	}

	@Override
	public String addUser(Users user) {
		user.setPassword("{bcrypt}" + passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "Success";
	}

}
