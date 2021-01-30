package com.osm.OmkarSM.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.osm.OmkarSM.domain.PersonDTO;

class Writer implements ItemWriter<PersonDTO> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	@Qualifier("JdbcTemplateForDMSI")
	protected JdbcTemplate jdbcTemplates = null;

	@Override
	public void write(List<? extends PersonDTO> items) throws Exception {
		for (PersonDTO p : items) {
			jdbcTemplates.update("Insert into osm_person values(osm_seq.nextval,?)", p.getName());
			logger.info("Value inserted: Name-" + p.getName());
		}
	}

};
