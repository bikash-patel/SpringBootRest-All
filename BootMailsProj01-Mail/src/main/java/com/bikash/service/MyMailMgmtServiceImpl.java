package com.bikash.service;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import javax.net.ssl.SSLContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MyMailMgmtServiceImpl implements IMyMailMgmtService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromMail;

	@Override
	public String shopping(String[] items, double[] price, String[] toMails) throws MessagingException {
		double totalPrice=0.0;
		for(double p:price)
		{
			totalPrice=totalPrice+p;
		}
		String msg=Arrays.toString(items)+" are purchased with price "+Arrays.toString(price)+" with Bill Ammount of "+totalPrice;
		String msg1=mailSender(msg,fromMail,toMails);
		return msg1;
	}
	private String mailSender(String msg,String fromMail,String[] toMails) throws MessagingException
	{
		MimeMessage message=sender.createMimeMessage();   //Empty Message Generated which support only text type
		MimeMessageHelper helper=new MimeMessageHelper(message,true); //Enable multipart ,Now it allow us to send any type of data in attachment
		helper.setSentDate(new Date());
		helper.setFrom("SBI<sbi_official@sbi.com>");
		helper.setTo(toMails);
		helper.setSubject("Ammount of 10,000 credited to your A/c No : XXXXXXXX8019");
		helper.setText("Ammount of 10,000 credited to your A/c No : XXXXXXXX8019. Current Balance is 12067.12");
		helper.addAttachment("sbi.png",new ClassPathResource("sbi.png")); //Attachment details
		sender.send(message);  //Send message
		return msg+"Mails sent to your mail account..";
	}
}
