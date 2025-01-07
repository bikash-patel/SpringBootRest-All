package com.bikash.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements JobExecutionListener {

	Long startTime,endTime;
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job started at : "+new Date());
		startTime=System.currentTimeMillis();
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job Ended at : "+new Date());
		endTime=System.currentTimeMillis();
		System.out.println("Job Execution Time : "+(endTime-startTime)+" milli second");
	}


}
