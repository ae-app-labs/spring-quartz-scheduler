package org.example.quartzscheduler.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.util.logging.Logger;

public class SampleJob implements Job {

	private static final Logger LOG = Logger.getLogger(SampleJob.class.getName());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOG.info("Executing Scheduled job!");
	}
}
