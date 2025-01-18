package com.bikash.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.BankAccount;
import com.bikash.service.IBankAccountService;

@Component
public class MyBankAccountRunners implements CommandLineRunner {

	@Autowired
	private IBankAccountService service;
	
	@Override
	public void run(String... args){
		try {
			BankAccount acc=new BankAccount("Sasmita",70000.0);
			String msg=service.openAccount(acc);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			String msg=service.withdrawMoney(10000000,1000.0);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
