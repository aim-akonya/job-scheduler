package com.aim.app;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJobListener extends JobListenerSupport {

	private Logger logger = LoggerFactory.getLogger(HelloJobListener.class);

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {

		logger.info("Job about to be executed");

	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

		logger.info("Job execution complete");

	}

	@Override
	public String getName() {
		return "helloJobListener";
	}

}
