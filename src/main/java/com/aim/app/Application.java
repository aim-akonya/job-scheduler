package com.aim.app;

import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;

import org.quartz.JobDetail;

public class Application {

	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		// grab the Schedular instance from the factory
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			scheduler.start();
			LOGGER.info("scheduler instance started");

			// TODO
			JobDetail job = newJob(HelloJob.class).withIdentity("myJob", "group1")
					.usingJobData("jobType", "password_expiry_notification")
					.build();
			
			JobDetail job2 = newJob(HelloJob.class).withIdentity("myJob2", "group2")
					.usingJobData("jobType", "password_expiry_notification")
					.build();

			// simple trigger
			Trigger trigger = newTrigger().withIdentity("myTrigger", "group1").startNow()
					.withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();
			
			
			//cron trigger
			Trigger trigger2 = newTrigger()
				    .withIdentity("myTrigger2", "group2")
				    .withSchedule(cronSchedule("0 17 9-10 * * ?"))
				    .forJob("myJob2", "group2")
				    .build();
			
			

			scheduler.scheduleJob(job, trigger);
			scheduler.scheduleJob(job2, trigger2);

			Thread.sleep(60000);

			scheduler.shutdown();
			LOGGER.info("scheduler instance stopped");
		} catch (Exception e) {
			e.printStackTrace();
			

		}
	}
}
