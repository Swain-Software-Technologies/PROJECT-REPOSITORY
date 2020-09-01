/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sslab.users.domain.UserAccount;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendUserAccUnlockEmail(UserAccount userAccount) {
			boolean isSent=false;
			Properties props= new Properties();
			props.put("mail.smtp.starttls.enable", "true");
		try {
				MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
				mimeMessageHelper.setTo(userAccount.getUserEmail());
				mimeMessageHelper.setSubject("Unlock your Account");
				mimeMessageHelper.setText(getUnlockAccEmailBody(userAccount), true);
				javaMailSender.send(mimeMessage);
				isSent=true;
		} catch (Exception e) {
			e.printStackTrace();
			isSent=false;
		}
		return isSent;
	}
	public String getUnlockAccEmailBody(UserAccount userAccount) throws IOException {
		
		StringBuffer buffer=new StringBuffer("");
		FileReader fileReader= new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		while (line != null) {
			buffer.append(line);
			line= bufferedReader.readLine();
		}
		bufferedReader.close();
		
//		format mail Body
		String mailBody=buffer.toString();
		mailBody = mailBody.replace("{FNAME}", userAccount.getUsrfirstName());
		mailBody = mailBody.replace("{LNAME}", userAccount.getUsrLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", userAccount.getUserPassword());
		mailBody = mailBody.replace("{EMAIL}", userAccount.getUserEmail());
		return mailBody;
		
	}
}
