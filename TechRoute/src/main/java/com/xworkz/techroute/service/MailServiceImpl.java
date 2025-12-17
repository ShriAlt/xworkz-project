package com.xworkz.techroute.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServiceImpl implements MailService{

    public MailServiceImpl(){
        log.info("no args of MailService");
    }
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendOtp(String toEmail, String otp) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
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
            log.error("error sending otp to {}", toEmail);
        }
        return false;
    }


}
