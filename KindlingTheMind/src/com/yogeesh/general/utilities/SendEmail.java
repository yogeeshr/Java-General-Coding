//package com.yogeesh.general.utilities;
//
//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
//
//public class SendEmail
//{
//    public static void main(String [] args)
//    {
//        // To email
//        String to = "yogeesh.srkvs@gmail.com";
//
//        // From email
//        String from = "yogeesh.srkvs@gmail.com";
//
//        // props
//        Properties properties = System.getProperties();
//
//        // email server - gmail in this case
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.socketFactory.port", "465");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.port", "465");
//
//        // Get the default Session object.
//        Session session = Session.getInstance(properties,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication("yogeesh.srkvs@gmail.com", "***");
//                    }
//                });
//
//        try{
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("This is the Subject Line!");
//
//            // Now set the actual message
//            message.setText("This is actual message");
//
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        }catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
//}