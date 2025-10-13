package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResetPasswordController {

    @Autowired
    ResetPasswordService resetPasswordService;

    @GetMapping("forgotPassword")
    public String forgotPassword(){
        return "ForgotPasswordPage";
    }
    @PostMapping("sendOtp")
    public String sendOtp(String identifier ){

       String result = resetPasswordService.sendAndSaveOtp(identifier);

        return "OtpVerificationPage";
    }
    @PostMapping("VerifyOtp")
    public String verifyOtp(String  otp){

        return "LoginPage";
    }
}
