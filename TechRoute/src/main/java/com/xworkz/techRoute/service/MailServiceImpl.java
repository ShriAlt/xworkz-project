package com.xworkz.techRoute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

    public MailServiceImpl(){
        System.out.println("no args of MailService");
    }

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendOtp(String toEmail) {

        return false;
    }
}
