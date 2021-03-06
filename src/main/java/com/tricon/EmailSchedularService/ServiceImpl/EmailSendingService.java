package com.tricon.EmailSchedularService.ServiceImpl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {

	private static final Logger log = LoggerFactory.getLogger(EmailSendingService.class);
	
	public void sendEmails() throws Exception{
		
		    log.info("In the Method sendEmails of EmailSendingService class");
			
			final String username = "mariyalasaicharan@gmail.com";
			final String password = "lallubhai";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(username));
				message.setSubject("Testing Subject");
				message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				log.info("In the Method sendEmails of EmailSendingService class and the exception is : "+e.getMessage());
				throw new RuntimeException(e);
			}
		}

}
