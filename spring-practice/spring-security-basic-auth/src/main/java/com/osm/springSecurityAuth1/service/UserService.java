package com.osm.springSecurityAuth1.service;

import com.osm.springSecurityAuth1.data.model.Users;

public interface UserService {

	String getAllUsersAsString();

	String addUser(Users user);
}
