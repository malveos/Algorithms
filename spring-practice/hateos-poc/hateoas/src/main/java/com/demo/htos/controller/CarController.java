package com.demo.htos.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.htos.repository.CarRepository;
import com.demo.htos.resource.CarResource;

@RestController
@RequestMapping(value = "/c", produces = {"application/hal+json"})
public class CarController {

	@Autowired
	private CarRepository carepository;

	@GetMapping("/cars/{id}")
	public ResponseEntity<Resources<CarResource>> allByPersonID(@PathVariable int id) {
		List<CarResource> plist = new LinkedList<>();;
		carepository.findAllByPersonid(id).forEach(p->plist.add(new CarResource(p)));
		final Resources<CarResource> resources = new Resources<>(plist);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarResource> get(@PathVariable final int id) throws Exception {
		return carepository.findById(id).map(p -> ResponseEntity.ok(new CarResource(p)))
				.orElseThrow(() -> new Exception());
	}
}
