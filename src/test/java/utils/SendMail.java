package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendMail {
    public void sendEmail(String fromEmail, String fromEmailPassword, String toEmail){

        // Sending email from gmail
        String host = "smtp.gmail.com";

        // Port of SMTP
        String port = "587";

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Create session object passing properties and authenticator instance
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromEmailPassword);
            }
        });

        try {

            // Create MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the Senders mail to From
            message.setFrom(new InternetAddress(fromEmail));

            // Set the recipients email address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Subject of the email
            message.setSubject("Leroy Merlin Retest");

            Multipart multipart = new MimeMultipart();

            // add the body message
            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText("Bonjour, \n  Ci-joint le fichier correspondant aux Retests sur le site leroymerlin.fr");
            multipart.addBodyPart(bodyPart);

            // attach the file
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.attachFile(new File((System.getProperty("user.dir"))+"\\src\\test\\resources\\Reports\\Verification.xlsx"));

            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            // Send email.
            Transport.send(message);
            System.out.println("Mail sent successfully");
        }catch (MessagingException | IOException me) {
            me.printStackTrace();
        }

    }
}
