package com.osm.OmkarSM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "osm_car")
@Entity
public class Car  {

	@Id
	@Column(name = "carid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "osm_seq")
	private Integer id;

	@Column(name = "pid")
	private Integer personid;

	@Column(name = "carname")
	private String carname;

	public Car() {
	}

	public Car(Integer id, String name) {
		super();
		this.personid = id;
		this.carname = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPersonid() {
		return personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	
}
