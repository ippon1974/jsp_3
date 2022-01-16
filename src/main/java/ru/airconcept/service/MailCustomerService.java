package ru.airconcept.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

public class MailCustomerService {

    public void sendMailToCustomer(String email){
        // Recipient's email ID needs to be mentioned.
        String to = email;

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
        properties.put ("mail.smtp.starttls.enable", "true");
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
            message.setFrom(new InternetAddress (from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
//            message.setText("This is actual message");

            ArrayList<String> list = new ArrayList<String>();
            list.add ("one");
            list.add ("two");
            list.add ("three");
            list.add ("four");
            list.add ("five");
            list.add ("six");
            StringBuilder listBuilder = new StringBuilder();
            for (int i = 0; i < list.size (); i++) {
                listBuilder.append("<H1>").append(list.get(i)).append("</H1>");
            }
            listBuilder.append ("----------------------------------------------");

            String namecompany = "Civek Water Jet";
            StringBuilder htmlBuilder = new StringBuilder();
            String textH = "Производство вентиляционных решеток";
            htmlBuilder.append("<H1>").append("Компания ").append(namecompany).append("</H1>");
            htmlBuilder.append("<H2>").append(textH).append("</H2>");
            message.setContent(listBuilder.toString(), "text/html; charset=UTF-8");

            System.out.println("sending...");
            // Send message

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
