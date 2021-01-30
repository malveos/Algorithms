package com.osm.OmkarSM.batch;

import org.springframework.batch.item.ItemProcessor;

import com.osm.OmkarSM.domain.PersonDTO;

public class PersonItemProcessor implements ItemProcessor<PersonDTO, PersonDTO> {

	@Override
	public PersonDTO process(PersonDTO item) throws Exception {
		PersonDTO newP = new PersonDTO();
		//newP.setId(item.getId()+10);
		newP.setName(item.getName().toUpperCase());
		return newP;
	}
	
};
