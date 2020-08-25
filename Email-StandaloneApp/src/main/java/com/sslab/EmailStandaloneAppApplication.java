package com.sslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sslab.utils.EmailUtils;

@SpringBootApplication
public class EmailStandaloneAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(EmailStandaloneAppApplication.class, args);
		EmailUtils emitUtils = ctxt.getBean(EmailUtils.class);
		
		String to = "trinath.95.swain.tinu@gmail.com";
		String subjects="<h1>This is for testing Email functionality</h1>";
		String body = "<b>This Email sent from sstech pvt.ltd<b>";
		
//		boolean isSent = emitUtils.sendEmail(to, subjects, body);
		boolean isSent = emitUtils.sendEmailNew(to, subjects, body);
		System.out.println("Email Sent ? "+ isSent);
	}

}
