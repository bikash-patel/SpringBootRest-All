package com.bikash.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.bikash.listener.MyListener;
import com.bikash.processor.MyItemProcessor;
import com.bikash.reader.MyItemReader;
import com.bikash.writer.MyItemWriter;

@Configuration
//@EnableBatchProcessing  3.x no need to configuration
public class MyStudentConfiguration {
	
	/*@Autowired
	private StepBuilderFactory step;
	
	@Autowired
	private JobBuilderFactory job;*/  //In 3.x this object will create using two param constructor
	
	@Autowired
	private MyItemReader reader;
	
	@Autowired
	private MyItemProcessor processor;
	
	@Autowired
	private MyItemWriter writer;
	
	@Autowired
	private MyListener listener;
	
	@Bean
	public Step createStep(JobRepository repo,PlatformTransactionManager txnMngr)
	{
		System.out.println("MyStudentConfiguration.createStep()");
		return new StepBuilder("step1", repo)
				.<Double,String>chunk(2,txnMngr)
				.reader(reader)
				.writer(writer)
				.processor(processor)
				.build();
	}
	
	@Bean
	public Job createJob(JobRepository repo,Step step)
	{
		System.out.println("MyStudentConfiguration.createJob()");
		return new JobBuilder("job", repo)
				  .incrementer(new RunIdIncrementer())
				  .listener(listener)
				  .start(step)
				  .build();
	}
	
}
