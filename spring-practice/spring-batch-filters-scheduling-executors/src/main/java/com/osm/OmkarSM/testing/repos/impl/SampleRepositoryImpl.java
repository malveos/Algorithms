package com.osm.OmkarSM.testing.repos.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.osm.OmkarSM.testing.repos.ISampleRepository;

@Repository("repos")
public class SampleRepositoryImpl implements ISampleRepository  {

	@Qualifier("JdbcTemplateForDMSI")
	@Autowired
	JdbcTemplate jt = null;

	public List<Long> getData() {
		return new LinkedList<>();
	}

	public String getStringMessage() {
		return str;
	}

	public String getNameByIdJDBC(int id) {
		return jt.query("select name from osm_person where pid = ? ", new Object[] {id} , rs-> {
			while(rs.next()) {
				return rs.getString("name");
			}
			return null;
		});
	}

}
