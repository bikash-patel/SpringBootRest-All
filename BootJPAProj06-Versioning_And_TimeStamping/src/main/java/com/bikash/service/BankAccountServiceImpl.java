package com.bikash.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.BankAccount;
import com.bikash.repository.MyBankAccRepo;

@Service
public class BankAccountServiceImpl implements IBankAccountService {
	
	@Autowired
	private MyBankAccRepo bankRepo;
	
	@Override
	public String openAccount(BankAccount account) {
		Long accNo=bankRepo.save(account).getAccNo();
		return "Account Opened with A/c No : "+accNo+" created on : "+account.getOpeningDate();
	}
	@Override
	public String withdrawMoney(long accountNo, double ammount) {
		BankAccount acc=bankRepo.findById(accountNo).orElseThrow(()-> new NullPointerException("Account number does not exist"));
		acc.setBalance(acc.getBalance()-ammount);
		bankRepo.save(acc);
		return "Money withdrawn of : "+ammount+" remainig balance : "+acc.getBalance()+" last updated : "+acc.getLastUpdatedOn()+" Modification done "+acc.getModificationCount()+" time";
	}
}
