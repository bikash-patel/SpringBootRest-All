package com.bikash.service;

import jakarta.mail.MessagingException;

public interface IMyMailMgmtService {
	public String shopping(String[] items,double[] price,String[] toMails) throws MessagingException;
}
