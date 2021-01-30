package com.osm.OmkarSM.scheduling;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;

import com.osm.OmkarSM.batch.BatchProcessing;

@Configuration
@EnableScheduling
public class CustomSchedularConfigurer implements SchedulingConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(CustomSchedularConfigurer.class);
	Marker marker = MarkerFactory.getMarker("SCHEDULE");

	private TaskScheduler taskScheduler;
	private ScheduledFuture<?> job1;

	private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

	@Autowired
	private BatchProcessing bpro;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		logger.info("hello world, I have just started up");
		logger.info("Load all records from DB to ConcurrentLinkedQueue");
		queue.add("Jobs ..");
	}

	@PreDestroy
	public void onDestroy() throws Exception {
		logger.info("Spring Container is destroyed! save queues stats in DB");
		Assert.notNull(bpro, " bpro bean is null");
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(2);// Set the pool of threads
		//threadPoolTaskScheduler.getActiveCount();
		threadPoolTaskScheduler.setRemoveOnCancelPolicy(true);
		threadPoolTaskScheduler.prefersShortLivedTasks();
		threadPoolTaskScheduler.setAwaitTerminationSeconds(1000);

		threadPoolTaskScheduler.setThreadNamePrefix("Job-Thread");
		threadPoolTaskScheduler.initialize();
		schedule(threadPoolTaskScheduler);// Schedule job
		taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);

		ThreadPoolTaskScheduler threadPoolTaskScheduler2 = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler2.setThreadNamePrefix("Mail-Thread");
		threadPoolTaskScheduler2.initialize();
		this.taskScheduler = threadPoolTaskScheduler2;
		taskRegistrar.setTaskScheduler(threadPoolTaskScheduler2);
	}

	private void schedule(TaskScheduler scheduler) {
		job1 = scheduler.schedule(() -> {
				logger.info(Thread.currentThread().getName() + " The Task1 executed at " + new Date());
				taskScheduler.schedule(() -> {
					logger.info( "add to the mail thread in this way");
				}, new Date());


				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				String cronExp = "5 * * * * ?";// Can be pulled from a db or create if db has information about it .
				return new CronTrigger(cronExp).nextExecutionTime(triggerContext);
			}
		});
		/*
		 * scheduler.addJob(updatedJobDetail, true, true); // 2nd parameter true means
		 * updating the existing job with the updated one.
		 * scheduler.rescheduleJob(oldTriggerKey, newTrigger);
		 * 
		 * scheduler.pauseJob(jobKey); scheduler.resumeJob(jobKey);
		 * scheduler.unscheduleJob(jobKey); scheduler.deleteJob(jobKey);
		 */
	}

	public String getCronExp(final Map<String, Object> configMap) {

		/*
		 * date = (1-31) , time = x:y, 
		 * day of week = "MON/TUE...",
		 * type of scheduler = (Daily , monthly , weeekly
		 * ) from user.
		 */

		String COLON = ":";
		String ZERO = "0";
		String WHITE_SPACE = " ";
		String ASTERISK = "*";
		String exp = "";

		logger.debug(">>  getCronExp");

		final String type = (String) configMap.get("SCHEDULER_TYPE");
		final String time = (String) configMap.get("TIME");
		final String[] split = time.split(COLON);
		String hour = split[0];
		String min = split[1];

		if ("00".equalsIgnoreCase(min)) {
			min = ZERO;
		}
		if ("00".equalsIgnoreCase(hour)) {
			hour = "0";
		}
		if ("daily".equalsIgnoreCase(type)) {
			// 0 30 2 * * ?
			exp = ZERO + WHITE_SPACE + min + WHITE_SPACE + hour + WHITE_SPACE + ASTERISK
					+ WHITE_SPACE + ASTERISK + WHITE_SPACE + "?";

		} else if ("monthly".equalsIgnoreCase(type)) {
			final String date = (String) configMap.get("START_DATE");
			// 0 30 2 dt * ?
			exp = ZERO + WHITE_SPACE + min + WHITE_SPACE + hour + WHITE_SPACE + date
					+ WHITE_SPACE + ASTERISK + WHITE_SPACE + "?";

		} else if ("weekly".equalsIgnoreCase(type)) {
			final String dayOfWeek = (String) configMap.get("DAY_OF_WEEK");
			// 0 30 2 ? * TUE
			exp = ZERO + WHITE_SPACE + min + WHITE_SPACE + hour + WHITE_SPACE + "?"
					+ WHITE_SPACE + ASTERISK + WHITE_SPACE + dayOfWeek;
		}

		logger.info("Latest cron  expression scheduler " + exp);
		logger.debug("<<  getCronExp");
		return exp;
	}

	public void refreshCronSchedule() throws InterruptedException, ExecutionException, TimeoutException {
		if (job1 != null) {
			job1.cancel(true);
			schedule(taskScheduler);
		}
		job1.isDone();
		job1.isCancelled();
		job1.getDelay(TimeUnit.SECONDS);

		job1.get(50000, TimeUnit.SECONDS); // wait for mentioned time catch diff for different causess
		// Above methods can be used to check running job status...
	}
}
