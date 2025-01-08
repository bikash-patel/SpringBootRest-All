package com.bikash.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class MyShoppingMgmtServiceImpl implements IMyShoppingMgmtService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${mail.cc}")
	private String cc;
	
	@Value("${mail.receiver}")
	private String personal;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Override
	public String shopping(String[] items, Double[] price){
		
		double totalPrice=0;
		for(double d:price)
		{
			totalPrice=totalPrice+d;
		}
		String msg="You have purchased item "+Arrays.toString(items)+" having price "+Arrays.toString(price)+" with total bill of : "+totalPrice;
		mailSender(msg);
		return msg;
	}

	@Override
	public String mailSender(String msg) {
		try {
			MimeMessage message=sender.createMimeMessage();  //Empty mail created
			MimeMessageHelper helper=new MimeMessageHelper(message,true); 
			  									//true to the constructor, it enables multipart support, 
							//which is necessary for sending emails with attachments or inline resources.
			
			helper.setFrom(new InternetAddress(fromMail,"Bikash Creation"));
			//helper.setFrom(fromMail);  
			
						//Setting mail id from which message will triggred
			            //If we won't pass InternetAddress object then at the receiver side
			            //it will show as mail came from <mail_address>@gmail.com
						//Here after setting InternetAddress here Bikash Creation will show 
						//as bussiness name
			helper.addCc(cc,personal);  //Here personal is To and cc will be in cc
			helper.setSubject("Bill amount for your last purchase at Fun Mall");
			helper.setSentDate(new Date());  //Setting send date
			helper.setText(msg);
			helper.addAttachment("EmployeeData.csv",new ClassPathResource("EmployeeData.csv"));
			sender.send(message);
		 }
	   catch(Exception e)
		{
		   e.printStackTrace();
		}
		return "Bill sent to your mail account";
}
}
