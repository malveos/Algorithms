package com.osm.OmkarSM.hateos.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.osm.OmkarSM.model.Car;

@RepositoryRestResource(path = "/osmCar")
public interface CarRepository extends CrudRepository<Car, Integer>{

	List<Car> findAllByPersonid(int id);

}
