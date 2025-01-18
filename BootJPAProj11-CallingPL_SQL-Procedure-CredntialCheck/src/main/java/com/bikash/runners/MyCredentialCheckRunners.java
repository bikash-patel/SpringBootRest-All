package com.bikash.runners;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.service.ICredentialCheckService;

@Component
public class MyCredentialCheckRunners implements CommandLineRunner {

	@Autowired
	private ICredentialCheckService service;
	
	@Override
	public void run(String... args) throws Exception {
		try(Scanner sc=new Scanner(System.in);) {
			System.out.println("Enter user name");
			String userName=sc.next();
			System.out.println("Enter password");
			String password=sc.next();
			String msg=service.login(userName,password);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
