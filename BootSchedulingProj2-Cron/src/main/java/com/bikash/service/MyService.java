package com.bikash.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	public MyService()
	{
		System.out.println("MyService.MyService() : 0-arg constructor");
	}
	//@Scheduled(cron = "2 * * * * *") // Every minute at 2 second
	//@Scheduled(cron = "* * * * * *") // Every second
	//@Scheduled(cron = "0/2 * * * * *") // Every 2 second
	//@Scheduled(cron = "* 40 8 * * *") // Every month morning each second of 8.40 minute
	//@Scheduled(cron = "0 42 8 * * *") // Every month morning at 8.42 minute
	//@Scheduled(cron = "0 0 0 26 11 *") // November 26th 12AM
	//@Scheduled(cron = "0 0 0 26 11 0,7") // November 26th 12AM if it Sunday only
	//@Scheduled(cron = "0-10 * * * * *") // Every minute from 0 to 10 second only
	//@Scheduled(cron = "10 0/2 * * * *") // Every two minute at 10 second
	//@Scheduled(cron = "10,20,30 47 9 * * *") // everyday 9.47 AM of 10,20 and 30 second
	//@Scheduled(cron = "0 54 9 * * 3#4") // every month 9.54 AM of 4th Wednesday 
	//@Scheduled(cron = "0 54 9 * * WED#4") // every month 9.54 AM of 4th Wednesday
	//@Scheduled(cron = "0 59 9 L-3 * *") // every month last 3 day at 9.59 AM
	@Scheduled(cron = "0 00 10 L * *") // every month last day at 10.00 AM
	public void getReport()
	{
		System.out.println("Execution Time : "+new Date());
	}
}
