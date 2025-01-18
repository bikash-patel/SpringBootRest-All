package com.bikash.service;

import com.bikash.entity.BankAccount;

public interface IBankAccountService {
	public String openAccount(BankAccount account);
	public String withdrawMoney(long accountNo,double ammount);
}
