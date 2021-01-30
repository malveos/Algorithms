package com.osm.OmkarSM.hateos.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.osm.OmkarSM.hateos.controller.CarController;
import com.osm.OmkarSM.hateos.controller.PersonController;
import com.osm.OmkarSM.model.Person;

public class PersonResource extends ResourceSupport {

	Person person;

	public PersonResource(final Person person){
		this.person = person;
		final int id = person.getId();
	
		add(linkTo(PersonController.class).withRel("p"));
		add(linkTo(methodOn(CarController.class).allByPersonID(id)).withRel("car"));
		try {
			add(linkTo(methodOn(PersonController.class).get(id)).withSelfRel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
