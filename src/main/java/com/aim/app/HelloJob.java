/**
 * 
 */
package com.aim.app;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author aim
 *
 */
public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.print(new Date().getTime());
		
	}

}
