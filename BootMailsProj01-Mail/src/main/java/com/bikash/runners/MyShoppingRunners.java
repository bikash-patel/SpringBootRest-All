package com.bikash.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.service.IMyShoppingMgmtService;

@Component
public class MyShoppingRunners implements CommandLineRunner {

	@Autowired
	private IMyShoppingMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			String msg=service.shopping(new String[] {"Shirt","Dhoti","Pant","Ear Buds"},
							new Double[] {756.0,999.0,650.0,1200.12});
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
