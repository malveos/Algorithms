package com.osm.OmkarSM.testing.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.osm.OmkarSM.model.Person;

public interface SampleRepository extends JpaRepository<Person, Integer>, ISampleRepository
{

	@Query(value ="select name from osm_person where pid = :id", nativeQuery= true)
	public String getNameByIdNative(@Param("id") int id);
/*
	@Query(value ="select p.name from Person p where p.id = :id")
	public String getNameByIdNative(@Param("id") int id);
*/
	@Query(value ="select p from Person p where p.id = :id")
	public Person getNameById(@Param("id") int id);
}
