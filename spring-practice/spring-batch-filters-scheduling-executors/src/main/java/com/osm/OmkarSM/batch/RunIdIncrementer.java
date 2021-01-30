package com.osm.OmkarSM.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class RunIdIncrementer implements JobParametersIncrementer {
	private static final String RUN_ID_KEY = "run.id";
	private String key = RUN_ID_KEY;
	private static final Logger logger = LoggerFactory.getLogger(RunIdIncrementer.class);

	public final void setKey(final String runIdKey) {
		this.key = runIdKey;
	}

	public final JobParameters getNext(final JobParameters parameters) {
		logger.info("Parameter: " + System.currentTimeMillis());
		return new JobParametersBuilder().addLong(key, System.currentTimeMillis()).toJobParameters();
	}
}
