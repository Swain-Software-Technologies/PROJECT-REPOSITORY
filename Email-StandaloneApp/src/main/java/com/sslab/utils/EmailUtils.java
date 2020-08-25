/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author TRINATH , Aug 11, 2020
 *
 * @Description :
 */
@Component
public class EmailUtils {
 
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String to, String subjects, String body) {
			
		System.out.println(javaMailSender);
		System.out.println(javaMailSender.getClass().getName());
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(subjects);
			simpleMailMessage.setText(body);
			javaMailSender.send(simpleMailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean sendEmailNew(String to, String subjects, String body) {
		
		try {
				MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
				
				String[] recipients = new String[2];
				recipients[0]="javabytrinath34@gmail.com";
				recipients[1]="trinath.95.swain.tinu@gmail.com";
				mimeMessageHelper.setTo(recipients);
				mimeMessageHelper.setSubject(subjects);
				mimeMessageHelper.setText(body, true);
				javaMailSender.send(mimeMessage);
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
