package com.gamesgo.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailManager {
	final static String mailUsername = "gamesgo@libero.it";
    final static String mailPassword = "mwXtrATJfI6b!MrpRn4A";
	public static void sendMail (String destinatario, String otpCode) throws MessagingException, IOException {
		
		Properties props = propertiesSettate();

        Session mailSession = Session.getInstance(props, null); // Creo la sessione

        Message msg = new MimeMessage( mailSession ); // Creo il messaggio.
        
        messaggioOtp(msg, destinatario, otpCode);
        
        Transport transport = mailSession.getTransport("smtps"); // Imposto l'oggetto Transport con protocollo SMTPS (SMTP su SSL).
        
        transport.connect("smtp.libero.it", mailUsername, mailPassword); // Mi connetto al server SMTP con l'autenticatore.
        
        transport.sendMessage(msg, msg.getAllRecipients()); // Invia il mesaggio al server SMTP.
        transport.close(); // Chiudo la connessione al server SMTP.
		
	}
	
	public static Message messaggioOtp (Message msg, String ricevente, String otpCode) throws AddressException, MessagingException, IOException {
		msg.setFrom( new InternetAddress(mailUsername) ); // Imposto il mittente del messaggio.
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ricevente));
        msg.setSubject("Your OTP Code");
                
        msg.setContent("Ecco a te il codice otp:\n"+otpCode+"\nUtilizzalo per identificarti come Admin.", "text/plain");

        msg.setSentDate(new Date()); // Imposto la data d'invio		
		
		return msg;
	}
	
	public static Properties propertiesSettate() {
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.libero.it"); 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        return props;
	}
	
}
