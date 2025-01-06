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
	@Scheduled(fixedDelay = 3000,initialDelay = 5000)
	public void getReport()
	{
		System.out.println("Generating Report at : "+new Date()+"..."+Thread.currentThread().getName());
		/*try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
}
