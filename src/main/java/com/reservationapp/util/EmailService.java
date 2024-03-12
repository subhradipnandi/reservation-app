package com.reservationapp.util;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;


@Component
public class EmailService {
    // Dependency injection for JavaMailSender to send emails
    private final JavaMailSender javaMailSender;

    // Constructor for EmailService with JavaMailSender dependency injection
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    // Method to send email with attachment
    public void sendEmail(String to, String subject, String text, byte[] attachment, String attachmentName) {
        try {
            // Create MimeMessage for sending email
            MimeMessage message = javaMailSender.createMimeMessage();

            // Create MimeMessageHelper to handle multipart MIME messages (with attachments)
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Set recipient email address
            helper.setTo(to);

            // Set email subject
            helper.setSubject(subject);

            // Set email body text
            helper.setText(text);


            // Add attachment to the email
            DataSource dataSource = new ByteArrayDataSource(attachment, "application/pdf");
            helper.addAttachment(attachmentName, dataSource);

            // Send the email
            javaMailSender.send(message);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}