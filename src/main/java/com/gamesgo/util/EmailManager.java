package com.gamesgo.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.gamesgo.dto.CheckoutDto;

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
	
	public static void sendMailCheckout (CheckoutDto checkout) throws MessagingException, IOException {
			
			Properties props = propertiesSettate();
	
	        Session mailSession = Session.getInstance(props, null); // Creo la sessione
	
	        Message msg = new MimeMessage( mailSession ); // Creo il messaggio.
	        checkout.setOrderNumber(RandomSegmentGenerator.generateRandomNumber(5));
	        // nome gioco
			// soldi spesi
			// data ordine
			// productImageUrl
			if (checkout.isRent()) { // rent.
				// inzio rent
				// fine rent (giorni)
				if (checkout.isOnline()) { // online.
					// chiave auto generata.
					
					mailRentDigital(msg, checkout);
					// RentDigital
				} else {
					// data arrivo ordine
					// tipo di consegna (normale, rapida, due_giorni)
					
					mailRentRetail(msg, checkout);
					// RentRetail
				}
			} else { // buy
				
				if (checkout.isOnline()) { // online.
					// chiave auto generata.
					
					mailBuyDigital(msg, checkout);

					// BuyDigital
				} else {
					// data arrivo ordine
					// tipo di consegna (normale, rapida, due_giorni)
					
					mailBuyRetail(msg, checkout);
					// BuyRetail
				}
			}
	        
	        
	        Transport transport = mailSession.getTransport("smtps"); // Imposto l'oggetto Transport con protocollo SMTPS (SMTP su SSL).
	        
	        transport.connect("smtp.libero.it", mailUsername, mailPassword); // Mi connetto al server SMTP con l'autenticatore.
	        
	        transport.sendMessage(msg, msg.getAllRecipients()); // Invia il mesaggio al server SMTP.
	        transport.close(); // Chiudo la connessione al server SMTP.
			
		}
	
	public static Message mailRentDigital(Message msg, CheckoutDto checkout) throws AddressException, MessagingException, IOException {
	    msg.setFrom(new InternetAddress(mailUsername)); // Imposto il mittente del messaggio.
	    
	    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(checkout.getTransactionEmail()));
	    msg.setSubject("Ordine Confermato");

	    // Carica il contenuto HTML dal file
	    String htmlTemplate = loadHtmlTemplate("templateMailRentDigital.html");
	    
	    String htmlContent = htmlTemplate.replace("{nomeCliente}", checkout.getTransactionName() + " " + checkout.getTransactionSurname())
	    							.replace("{nomeGioco}", checkout.getGameTitle())
	    							.replace("{prezzo}", String.valueOf(checkout.getGamePrice()))
	    							.replace("{dataOrdine}", DateManager.dateToString(checkout.getShippingOrderDate()))
	    							.replace("{chiave}", checkout.getProductKey())
									.replace("{dataRestituzione}",DateManager.dateToString(checkout.getRentFinishDate()))
	    							.replace("{productImageUrl}", checkout.getGamePhotoUrl())
	    							.replace("{numeroOrdine}", checkout.getOrderNumber())
	    							.replace("{giorni}", String.valueOf(checkout.getRentDays()));

	    msg.setContent(htmlContent, "text/html"); // Imposta il contenuto come HTML

	    msg.setSentDate(new Date()); // Imposto la data d'invio
	    
	    return msg;
	}
	public static Message mailRentRetail(Message msg, CheckoutDto checkout) throws AddressException, MessagingException, IOException {
	    msg.setFrom(new InternetAddress(mailUsername)); // Imposto il mittente del messaggio.
	    
	    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(checkout.getTransactionEmail()));
	    msg.setSubject("Ordine Confermato");

	    // Carica il contenuto HTML dal file
	    String htmlTemplate = loadHtmlTemplate("templateMailRentRetail.html");
	    
	    String htmlContent = htmlTemplate.replace("{nomeCliente}", checkout.getTransactionName() + " " + checkout.getTransactionSurname())
	    							.replace("{nomeGioco}", checkout.getGameTitle())
	    							.replace("{prezzo}", String.valueOf(checkout.getGamePrice()))
	    							.replace("{dataOrdine}", DateManager.dateToString(checkout.getShippingOrderDate()))
	    							.replace("{dataArrivo}", DateManager.dateToString(checkout.getShippingScheduleDate()))
	    							.replace("{spedizione}", checkout.getShippingMethod())
	    							.replace("{dataRestituzione", DateManager.dateToString(checkout.getRentFinishDate()))
	    							.replace("{productImageUrl}", checkout.getGamePhotoUrl())
	    							.replace("{giorni}", String.valueOf(checkout.getRentDays()))
	    							.replace("{numeroOrdine}", checkout.getOrderNumber());

	    msg.setContent(htmlContent, "text/html"); // Imposta il contenuto come HTML

	    msg.setSentDate(new Date()); // Imposto la data d'invio
	    
	    return msg;
	}
	public static Message mailBuyDigital(Message msg, CheckoutDto checkout) throws AddressException, MessagingException, IOException {
	    msg.setFrom(new InternetAddress(mailUsername)); // Imposto il mittente del messaggio.
	    
	    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(checkout.getTransactionEmail()));
	    msg.setSubject("Ordine Confermato");

	    // Carica il contenuto HTML dal file
	    String htmlTemplate = loadHtmlTemplate("templateMailSellDigital.html");
	    
	    String htmlContent = htmlTemplate.replace("{nomeCliente}", checkout.getTransactionName() + " " + checkout.getTransactionSurname())
	    							.replace("{nomeGioco}", checkout.getGameTitle())
	    							.replace("{prezzo}", String.valueOf(checkout.getGamePrice()))
	    							.replace("{dataOrdine}", DateManager.dateToString(checkout.getShippingOrderDate()))
	    							.replace("{chiave}", checkout.getProductKey())
	    							.replace("{productImageUrl}", checkout.getGamePhotoUrl())
	    							.replace("{numeroOrdine}", checkout.getOrderNumber());

	    msg.setContent(htmlContent, "text/html"); // Imposta il contenuto come HTML

	    msg.setSentDate(new Date()); // Imposto la data d'invio
	    
	    return msg;
	}
	public static Message mailBuyRetail(Message msg, CheckoutDto checkout) throws AddressException, MessagingException, IOException {
	    msg.setFrom(new InternetAddress(mailUsername)); // Imposto il mittente del messaggio.
	    
	    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(checkout.getTransactionEmail()));
	    msg.setSubject("Ordine Confermato");

	    // Carica il contenuto HTML dal file
	    String htmlTemplate = loadHtmlTemplate("templateMailSellRetail.html");
	    
	    String htmlContent = htmlTemplate.replace("{nomeCliente}", checkout.getTransactionName() + " " + checkout.getTransactionSurname())
	    							.replace("{nomeGioco}", checkout.getGameTitle())
	    							.replace("{prezzo}", String.valueOf(checkout.getGamePrice()))
	    							.replace("{dataOrdine}", DateManager.dateToString(checkout.getShippingOrderDate()))
	    							.replace("{dataArrivo}", DateManager.dateToString(checkout.getShippingScheduleDate()))
	    							.replace("{spedizione}", checkout.getShippingMethod())
	    							.replace("{productImageUrl}", checkout.getGamePhotoUrl())
	    							.replace("{numeroOrdine}", checkout.getOrderNumber());

	    msg.setContent(htmlContent, "text/html"); // Imposta il contenuto come HTML

	    msg.setSentDate(new Date()); // Imposto la data d'invio
	    
	    return msg;
	}
	
	public static String loadHtmlTemplate(String fileName) throws IOException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
	        if (inputStream == null) {
	            throw new FileNotFoundException("File not found: " + fileName);
	        }
	        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
	    }
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
