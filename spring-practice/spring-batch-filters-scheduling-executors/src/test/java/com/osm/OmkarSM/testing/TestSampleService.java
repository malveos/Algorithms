package com.osm.OmkarSM.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.osm.OmkarSM.testing.repos.SampleRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestSampleService {
	/**
	 * 
	 * Here teting of methods in SampleService is done, 
	 * we mock SampleRepository class and stubb data for testing
	 * 
	 */
	@Mock
	private SampleRepository repos;

	@InjectMocks
	private SampleService service;

	@Test
	public void checkwithtwo() {
		// stub custom data
		List<Long> arL = new LinkedList<>();
		arL.add(12L);arL.add(13L);arL.add(122L);arL.add(128L);
		when(repos.getData()).thenReturn(arL);

		long max = service.getMax();
		assertEquals(128, max);
	}

	@Test
	public void checkwithnull() {
		// stub custom data
		List<Long> arL = null;
		when(repos.getData()).thenReturn(arL);

		long max = service.getMax();
		assertEquals(0, max);
	}

}
