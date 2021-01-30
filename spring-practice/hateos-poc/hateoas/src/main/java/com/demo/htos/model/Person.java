package com.demo.htos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "osm_person")
@Entity
public class Person {

	@Id
	@Column(name = "PID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	public Person() {
	}

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
