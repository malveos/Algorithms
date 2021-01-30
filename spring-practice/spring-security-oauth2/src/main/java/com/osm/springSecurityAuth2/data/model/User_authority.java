package com.osm.springSecurityAuth2.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User_authority {

	@GeneratedValue
	@Id
	Long user_authority_map_id;
	Long user_id;
	Long authority_id;

	public Long getUser_authority_map_id() {
		return user_authority_map_id;
	}

	public void setUser_authority_map_id(Long user_authority_map_id) {
		this.user_authority_map_id = user_authority_map_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getAuthority_id() {
		return authority_id;
	}

	public void setAuthority_id(Long authority_id) {
		this.authority_id = authority_id;
	}

}
