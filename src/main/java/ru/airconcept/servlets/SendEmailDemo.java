package ru.airconcept.servlets;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/send")
public class SendEmailDemo extends HttpServlet {

    static final String SENDER_EMAIL_ADDRESS = "box@wcut.ru";
    static final String SENDER_EMAIL_PASSWORD = "k4b8c32";
    static final String SENDER_HOST = "smtp.yandex.ru";
    static final String SENDER_PORT = "465";
    static final String RECEIVER_EMAIL_ADDRESS = "mail@htz.ru";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties properties = new Properties ( );
        properties.put ("mail.smtp.host", SENDER_HOST);
        properties.put ("mail.smtp.port", SENDER_PORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put ("mail.from", SENDER_EMAIL_ADDRESS);
        properties.put ("mail.smtp.password", SENDER_EMAIL_PASSWORD);
        properties.put ("mail.smtp.auth", "true");
//        properties.put ("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance (properties,
                new javax.mail.Authenticator ( ) {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication (SENDER_EMAIL_ADDRESS, SENDER_EMAIL_PASSWORD);
                    }
                });

        resp.setContentType("text/html");

        String docType = "<!DOCTYPE html>";
        String title = "Demo send email from JAVA ";

        PrintWriter writer = resp.getWriter();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL_ADDRESS));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(RECEIVER_EMAIL_ADDRESS));
            message.setSubject("Вентиляционные решетки Civek Water Jet");
            message.setText("Привет Вован как дела ??? Еще раз проверяем данные отправки ...");
            Transport.send(message);
            String sendEmailResultMessage = "Email is successfully sent!";
            writer.println(docType + "<html>" +
                    "<head>" +
                    "<title>" + title + "</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1>" + sendEmailResultMessage + "</h1>" +
                    "</body>" +
                    "</html>");


        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
