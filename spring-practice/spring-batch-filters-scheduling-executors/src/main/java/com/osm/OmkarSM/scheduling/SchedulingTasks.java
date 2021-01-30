package com.osm.OmkarSM.scheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.osm.OmkarSM.batch.BatchProcessing;

@Component
public class SchedulingTasks {

	private static final Logger logger = LoggerFactory.getLogger(SchedulingTasks.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	private BatchProcessing bpro;

	@Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
		logger.info( "Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}

	@Scheduled(fixedDelay = 2000)
	public void scheduleTaskWithFixedDelay() {
		logger.info( "Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException ex) {
			logger.error( "Ran into an error {}", ex);
			//throw new IllegalStateException(ex);
		}
	}

	@Scheduled(fixedRate = 2000, initialDelay = 5000)
	public void scheduleTaskWithInitialDelay() {
		logger.info( "Fixed Rate Task with Initial Delay :: Execution Time - {}",
				dateTimeFormatter.format(LocalDateTime.now()));
	}

	@Scheduled(cron = "0 0/1 * 1/1 * ? ")
	public void scheduleTaskWithCronExpression() {
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

		bpro.executeJob();
		logger.info( "Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) + " Name-> "
				+ Thread.currentThread().getName() + " ThreadSet-> " + threadSet);

	}

}