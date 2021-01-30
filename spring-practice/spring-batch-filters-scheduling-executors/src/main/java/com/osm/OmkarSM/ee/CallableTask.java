package com.osm.OmkarSM.ee;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.osm.OmkarSM.domain.PersonDTO;

public class CallableTask implements Callable<Boolean>, ManagedTaskListener, ManagedTask {

	private int id;
	private GetAllPersons repos;
	private Logger log = LoggerFactory.getLogger(this.getClass().getCanonicalName());

	public CallableTask(int id, GetAllPersons repos) {
		this.id = id;
		this.repos = repos;
	}

	@Override
	public Boolean call() throws Exception {
		List<PersonDTO> ls = repos.getPersons();
		String s = "";
		s = s + ("[");
		for (PersonDTO p : ls) {
			s = s + ("{" + p.getId() + "," + p.getName() + " }");
		}
		s = s + ("]");
		log.info(s);
		Thread.sleep(10000);
		return true;
	}

	@Override
	public void taskSubmitted(Future<?> future, ManagedExecutorService executor, Object task) {
		log.info("Task Submitted " + id);
	}

	@Override
	public void taskAborted(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
		log.info("Task Aborted " + id);
	}

	@Override
	public void taskDone(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
		log.info("Task Done " + id);
	}

	@Override
	public void taskStarting(Future<?> future, ManagedExecutorService executor, Object task) {
		log.info("Task Starting " + id);
	}

	@Override
	public ManagedTaskListener getManagedTaskListener() {
		return null;
	}

	@Override
	public Map<String, String> getExecutionProperties() {
		return null;
	}

}
