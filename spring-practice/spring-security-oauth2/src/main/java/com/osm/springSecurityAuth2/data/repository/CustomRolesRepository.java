package com.osm.springSecurityAuth2.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.osm.springSecurityAuth2.data.model.Authority;

public interface CustomRolesRepository extends CrudRepository<Authority, Long> {

	@Query(value = "select au.* "
			+ " from authority au "
			+ " JOIN user_authority ua ON ua.user_id = :userId "
			+ "		AND ua.authority_id = au.authority_id "
			, nativeQuery= true)
	List<Authority> findByUserId(Long userId);
}
