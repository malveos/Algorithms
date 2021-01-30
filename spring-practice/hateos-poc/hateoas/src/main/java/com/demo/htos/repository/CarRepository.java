package com.demo.htos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.htos.model.Car;

@RepositoryRestResource(path = "/osmcar")
public interface CarRepository extends CrudRepository<Car, Integer>{

	List<Car> findAllByPersonid(int id);

}
