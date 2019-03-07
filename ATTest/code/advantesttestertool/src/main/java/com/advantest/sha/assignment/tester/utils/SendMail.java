
package com.advantest.sha.assignment.tester.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class SendMail {
    private static final Logger LOG = LoggerFactory.getLogger(SendMail.class);
    
	private static Properties appProp;
	
	static {
		File appProFile;
		try {
			appProFile = new ClassPathResource("application.properties").getFile();
			appProp = new Properties();
			appProp.load(new FileInputStream(appProFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public void sendEmail(String toMail, String subject, String txtMsg) throws Exception {
        LOG.info(">>> sendEmail >>>");
        
		// SMTP_EMAIL_ID
		final String fromMailId = appProp.getProperty("SMTP_EMAIL_ID");
		// SMTP_PASSWORD
		final String password = appProp.getProperty("SMTP_PASSWORD");
		// SMTP_SERVER_NAME
		String host = appProp.getProperty("SMTP_SERVER_NAME");
		String port = appProp.getProperty("SMTP_PORT_NUMBER");
        
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.sendpartial", "true");
        
        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromMailId, password);
            }
        });
        
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMailId));
			if (toMail != null) {
				String[] emails = toMail.split(";");
				Address[] to = new Address[emails.length];
				int counter = 0;
				for(String email : emails) {
					to[counter] = new InternetAddress(email.trim());
					counter++;
				}
				message.setRecipients(Message.RecipientType.TO, to);
			}
			message.setSubject(subject);
			// message.setContent(txtMsg, "text/html");
			message.setContent(txtMsg, "text/html; charset=utf-8");
			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect();
			Transport.send(message);

			LOG.debug("Sent message successfully....");

		} catch (MessagingException e) {
			LOG.error("Unable to send email. Please see log {} ", e);
        }
		LOG.info(txtMsg);

        LOG.info("<<< sendEmail <<<");

    }

}
