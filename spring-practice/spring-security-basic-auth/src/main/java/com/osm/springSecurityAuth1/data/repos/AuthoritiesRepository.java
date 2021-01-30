package com.osm.springSecurityAuth1.data.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.osm.springSecurityAuth1.data.model.Authorities;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

	List<Authorities> findByUsername(String username);
}
