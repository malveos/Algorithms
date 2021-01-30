package com.demo.htos.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ResourceSupport;

import com.demo.htos.controller.CarController;
import com.demo.htos.model.Car;

public class CarResource extends ResourceSupport {

	Car car;

	public CarResource(final Car car){
		this.car = car;
		final int id = car.getId();
		add(linkTo(CarController.class).withRel("c"));
		try {
			add(linkTo(methodOn(CarController.class).get(id)).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
