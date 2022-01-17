package ru.airconcept.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailAdminService {

   public void send(){
       // Recipient's email ID needs to be mentioned.
       String to = "post2074@gmail.com";

       // Sender's email ID needs to be mentioned
       String from = "post2074@gmail.com";

       // Assuming you are sending email from through gmails smtp
       String host = "smtp.gmail.com";

       // Get system properties
       Properties properties = System.getProperties();

       // Setup mail server
       properties.put("mail.smtp.host", host);
       properties.put("mail.smtp.port", "465");
       properties.put("mail.smtp.ssl.enable", "true");
       properties.put("mail.smtp.auth", "true");

       // Get the Session object.// and pass username and password
       Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

           protected PasswordAuthentication getPasswordAuthentication() {

               return new PasswordAuthentication("post2074@gmail.com", "k4b8c321974");
           }

       });

       // Used to debug SMTP issues
       session.setDebug(true);

       try {
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(from));

           // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

           // Set Subject: header field
           message.setSubject("This is the Subject Line for Administrator!");

           // Now set the actual message
           message.setText("Hi Admin How are you ?");

           System.out.println("sending...");
           // Send message
           Transport.send(message);
           System.out.println("Sent message successfully....");
       } catch (MessagingException mex) {
           mex.printStackTrace();
       }
   }

}
