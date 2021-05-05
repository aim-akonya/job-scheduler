package com.aim.app;

import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.CalendarIntervalScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.JobDetail;

import static org.quartz.DateBuilder.*;

public class Application {

	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		// grab the Schedular instance from the factory
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			scheduler.start();
			LOGGER.info("scheduler instance started");

			// TODO
			JobDetail job = newJob(HelloJob.class).withIdentity("myJob", "group1").build();

			// trigger
			Trigger trigger = newTrigger().withIdentity("myTrigger", "group1").startNow()
					.withSchedule(simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

			scheduler.scheduleJob(job, trigger);

			Thread.sleep(6000);

			scheduler.shutdown();
			LOGGER.info("scheduler instance stopped");
		} catch (Exception e) {
			LOGGER.error("error stopping schedular instance");

		}
	}
}
