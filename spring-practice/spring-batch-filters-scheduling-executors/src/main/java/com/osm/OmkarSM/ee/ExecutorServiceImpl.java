package com.osm.OmkarSM.ee;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutorServiceImpl {

	//@Resource(lookup ="java:comp/DefaultManagedExecutorService")
	//private ManagedExecutorService mes;

	@Autowired
	private GetAllPersons repos;

	public void callExecutorService() {
		ExecutorService mes = Executors.newFixedThreadPool(4);
		for(int i= 1; i<16;i++) {
			mes.submit(new CallableTask(i, repos));
		}
	}
}
