package org.example.quartzscheduler;

import org.example.quartzscheduler.demo.SampleJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class QuartzSchedulerApplication implements CommandLineRunner {

	@Autowired
	private Scheduler scheduler;

	public static void main(String[] args) {
		SpringApplication.run(QuartzSchedulerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JobDetail jobDetail = JobBuilder.newJob(SampleJob.class)
				.withIdentity("sampleJob")
				.build();

		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("sampleTrigger")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
				.build();

		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}
}
