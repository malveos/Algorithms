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

import com.demo.htos.repository.PersonRepositoryUsingHateOS;
import com.demo.htos.resource.PersonResource;

@RestController
@RequestMapping(value = "/p", produces = {"application/hal+json"})
public class PersonController {

	@Autowired
	private PersonRepositoryUsingHateOS personRepository;

	@GetMapping
	public ResponseEntity<Resources<PersonResource>> all() {
		List<PersonResource> plist = new LinkedList<>();;
		personRepository.findAll().forEach(p->plist.add(new PersonResource(p)));
		final Resources<PersonResource> resources = new Resources<>(plist);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
		return ResponseEntity.ok(resources);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonResource> get(@PathVariable final int id) throws Exception {
		return personRepository.findById(id).map(p -> ResponseEntity.ok(new PersonResource(p)))
				.orElseThrow(() -> new Exception());
	}
}
