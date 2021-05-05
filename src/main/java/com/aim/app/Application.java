package com.aim.app;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		
		//grab the Schedular instance from the factory
		try {
			Scheduler scheduler =  StdSchedulerFactory.getDefaultScheduler();
			
			scheduler.start();
			LOGGER.info("scheduler instance started");
			
			scheduler.shutdown();
			LOGGER.info("scheduler instance stopped");
		}catch(Exception e) {
			LOGGER.error("error stopping schedular instance");
			
		}
	}
}
