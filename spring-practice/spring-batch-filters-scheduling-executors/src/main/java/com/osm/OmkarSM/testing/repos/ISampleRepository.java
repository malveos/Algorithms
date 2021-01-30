package com.osm.OmkarSM.testing.repos;

import java.util.List;

public interface ISampleRepository {

	public static String str ="OmkarMAne";

	List<Long> getData();

	public String getStringMessage();

	public String getNameByIdJDBC(int id);
}
