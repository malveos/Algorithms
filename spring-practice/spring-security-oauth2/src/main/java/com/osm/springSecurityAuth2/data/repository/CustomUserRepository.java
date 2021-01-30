package com.osm.springSecurityAuth2.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osm.springSecurityAuth2.data.model.User;

public interface CustomUserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
