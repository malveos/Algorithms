package com.osm.OmkarSM.ee;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.osm.OmkarSM.domain.PersonDTO;

@Repository
public class GetAllPersons {

	@Autowired
	@Qualifier("JdbcTemplateForDMSI")
	protected JdbcTemplate jdbcTemplates = null;

	public List<PersonDTO> getPersons() {
		List<PersonDTO> ls = jdbcTemplates.query("SELECT * FROM osm_person", rs -> {
			List<PersonDTO> pl = new LinkedList<>();
			while (rs.next()) {
				PersonDTO p = new PersonDTO();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				pl.add(p);
			}
			return pl;
		});
		return ls;
	}
}
