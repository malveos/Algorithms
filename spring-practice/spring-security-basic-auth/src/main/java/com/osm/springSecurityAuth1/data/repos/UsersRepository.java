package com.osm.springSecurityAuth1.data.repos;

import org.springframework.data.repository.CrudRepository;

import com.osm.springSecurityAuth1.data.model.Users;

public interface UsersRepository extends CrudRepository<Users, String> {

}
