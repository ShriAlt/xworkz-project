package com.xworkz.techRoute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailServiceImpl implements MailService{

    public MailServiceImpl(){
        System.out.println("no args of MailService");
    }

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendOtp(String toEmail, String otp) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setReplyTo("shriharshakm10@gmail.com");
            simpleMailMessage.setTo(toEmail);
            simpleMailMessage.setSubject("your TechRoute otp");
            String body = "your otp for the application is " +
                    " : " +
                    otp +
                    "do not share this with anyone ";
            simpleMailMessage.setText(body);
            mailSender.send(simpleMailMessage);
            return true;
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return false;
    }


}
