package com.osm.OmkarSM.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.osm.OmkarSM.domain.PersonDTO;

public class PersonFieldSetMapper implements FieldSetMapper<PersonDTO> {

	@Override
	public PersonDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		PersonDTO p = new PersonDTO();
		p.setName(fieldSet.readString("NAME"));
		return p;
	}

};