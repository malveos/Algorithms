package com.demo.htos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.htos.model.Person;

@RepositoryRestResource(path = "/osmperson")
public interface PersonRepositoryUsingHateOS  extends CrudRepository<Person, Integer>{

}
