package com.osm.OmkarSM.hateos.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.osm.OmkarSM.model.Person;

@RepositoryRestResource(path = "/osmPerson")
public interface PersonRepositoryUsingHateOS  extends CrudRepository<Person, Integer>{

}
