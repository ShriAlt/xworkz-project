package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String sendOtp(String identifier , Model model){
       String result = resetPasswordService.sendAndSaveOtp(identifier);
       switch (result){
           case "noPhoneNumber"  :{
               return "ForgotPasswordPage";
           }
           case "sendError"  :{
               return "ForgotPasswordPage";
           }
           case "dbError"  :{
               return "ForgotPasswordPage";
           }
           case "invalid"  :{
               return "ForgotPasswordPage";
           }
       }
       model.addAttribute("identifier",identifier);
        return "OtpVerificationPage";
    }
    @PostMapping("VerifyOtp")
    public String verifyOtp(String  otp , String identifier, Model model ){
       String result = resetPasswordService.validateAndVerifyOtp(identifier,otp);

       switch (result){
           case "invalid":{
               model.addAttribute("error","something went wrong ");
               return "OtpVerificationPage";
           }
           case "expired":{
               model.addAttribute("error","expired");
               return "OtpVerificationPage";
           }
           case "misMatch":{
               model.addAttribute("error","wrongOtp");
               return "OtpVerificationPage";
           }
           case "invalidIdentifier":{
               model.addAttribute("error","no identifier ");
               return "OtpVerificationPage";
           }
       }
       model.addAttribute("identifier",identifier);
        return "ResetPasswordPage";
    }

    @PostMapping("UpdatePassword")
    public String updatePassword(String identifier,String password , String confirmPassword , Model model){
        String result = resetPasswordService.ValidateAndUpdatePassword(identifier,password,confirmPassword);
        switch (result){
            case "invalid" :
            case "dbError" : {
                model.addAttribute("error","something went wrong");
                return "ResetPasswordPage";
            }
            case "missMatch" :{
                model.addAttribute("error","password missMatch");
                return "ResetPasswordPage";
            }
            case "nullError" :{
                model.addAttribute("error","can not be  null");
                return "ResetPasswordPage";
            }
            case "invalidPassword" :{
                model.addAttribute("error","password is not valid ");
                return "ResetPasswordPage";
            }
        }
        return "LoginPage";
    }
}
