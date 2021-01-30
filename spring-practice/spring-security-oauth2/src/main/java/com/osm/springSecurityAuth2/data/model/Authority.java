package com.osm.springSecurityAuth2.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Authority {

	@GeneratedValue
	@Id
	Long authority_id;
	String authority;
	public Long getAuthority_id() {
		return authority_id;
	}
	public void setAuthority_id(Long authority_id) {
		this.authority_id = authority_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
