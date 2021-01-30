package com.osm.OmkarSM.domain;

public class PersonDTO {
	Integer id;
	String name;

	public PersonDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public PersonDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
