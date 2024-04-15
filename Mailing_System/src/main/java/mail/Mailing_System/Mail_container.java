package mail.Mailing_System;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail_container {
	public static void main(String [] args) {
		
		System.out.println("Welcome to the mailing system via javaAPI");
		sendMail();
	}



private static void sendMail() {
	
	//message Variables
	String msg="Agr msg aaya h toh hm yeh sikh gyeeee...hihihihihi  ";
	String from="simran19.sahay19@gmail.com";
	//String to="";
	String subject="mail system check kr rhe hai ";
	
	//server parameters
	String host1="smtp.gmail.com";
	String port1="465";
	String ssl1="true";
	String auth1="true";
	
	//System parameters
	Properties p=System.getProperties();
	System.out.println("The properties are: "+p);
	
	//setting the system properties to server's data to land at the correct destination
	p.put("mail.smtp.host",host1);
	p.put("mail.smtp.port",port1);
	p.put("mail.smtp.ssl.enable",ssl1);
	p.put("mail.smtp.auth",auth1);
	
	
	//created a session object that will set the properties and authenticate the mail
	Session s= Session.getInstance(p,new Authenticator() {
	
		@Override
		protected PasswordAuthentication  getPasswordAuthentication() {
		
		return new PasswordAuthentication("simran19.sahay19@gmail.com","nejg llzw vtkf fjrf");
		}
	});
	s.setDebug(true);

	
	MimeMessage message_object=new MimeMessage(s);
	
	Address [] ad=new Address[3];
	
	try {
		
		ad[0]= new InternetAddress("sonalranisr88@gmail.com");
		ad[1]= new InternetAddress("rajghosh1709@gmail.com");
		ad[2]= new InternetAddress("prabhakarrai.kumar31@gmail.com");
		
		try {
			message_object.setFrom(from);
			message_object.setSubject(subject);
			message_object.setText(msg);
			message_object.addRecipients(Message.RecipientType.BCC, ad);
			
			Transport.send(message_object);

			System.out.println("Mail sent successfully");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	
	
	
	catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}