package com.osm.OmkarSM.testing;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;

import com.osm.OmkarSM.testing.repos.SampleRepository;

public class SampleService {

	@Autowired
	private SampleRepository fm;

	long getMax() {
		if(fm.getData() == null) {
			return 0;
		}
		return fm.getData().stream().max(Comparator.comparingLong(l->l.longValue())).orElseThrow().longValue();
	}

	public String getName(int id){
		return fm.getNameById(id).getName();
	}
}
