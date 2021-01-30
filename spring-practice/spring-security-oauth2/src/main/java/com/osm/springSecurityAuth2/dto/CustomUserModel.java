package com.osm.springSecurityAuth2.dto;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserModel extends User {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String dashboard;
	private List<GrantedAuthority> authorities;

	public CustomUserModel(String username, String password, String dashboard, List<GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.username = username;
		this.password = password;
		this.dashboard = dashboard;
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDashboard() {
		return dashboard;
	}

	public void setDashboard(String dashboard) {
		this.dashboard = dashboard;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
