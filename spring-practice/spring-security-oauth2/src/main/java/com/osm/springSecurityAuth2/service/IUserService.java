package com.osm.springSecurityAuth2.service;

import com.osm.springSecurityAuth2.dto.CustomUserModel;

public interface IUserService {

	CustomUserModel getUserFromUserName(String username);
}
