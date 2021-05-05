/**
 * 
 */
package com.aim.app;


import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author aim
 *
 */
public class HelloJob implements Job{
	
	private static Logger LOGGER = LoggerFactory.getLogger(HelloJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobKey key = context.getJobDetail().getKey();
		JobDataMap dataMap =  context.getJobDetail().getJobDataMap();
		
		String jobType = dataMap.getString("jobType");
		
		LOGGER.info("Job Instance "+key +". Job Type "+jobType);
		
	}
	
	

}
