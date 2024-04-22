/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g05.project;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author CHAMMA
 */
public class emailtwo {
    public boolean sendEmail(String to, String from, String sub, String msg) {
        boolean flag = false;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "myshare82"; // Replace with your Gmail username
        String password = "djjofcljbuogpbgk"; // Replace with your Gmail password or an app password if you have 2-step verification enabled

        // Session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(sub);

            message.setText(msg);

            Transport.send(message);
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    
    public static void main(String [] args){
        emailtwo ob=new emailtwo();
        ob.sendEmail("poornima.d@sliit.lk","myshare82@gmail.com", "notification", "order has been allocated");
    }
}