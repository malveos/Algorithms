package com.osm.OmkarSM.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osm.OmkarSM.model.Person;
import com.osm.OmkarSM.testing.repos.SampleRepository;

@RestController
public class ControllerJunit {

	@Autowired
	private SampleRepository ser;

	@GetMapping(value = "/get", produces = "application/json" )
	public String getHello() {
		return ser.getStringMessage();
	}

	@PostMapping(value = "/getJson", produces = "application/json" )
	public Person getJSon() {
		return new Person(15, "Omkar");
	}

}
