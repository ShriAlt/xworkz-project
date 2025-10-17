package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
       IssueCode result = resetPasswordService.sendAndSaveOtp(identifier);
       switch (result){
           case NO_PHONE_NUMBER:  {
               model.addAttribute("error","please register");
               return "ForgotPasswordPage";
           }
           case SEND_ERROR:  {
               model.addAttribute("error","could not send otp ");
               return "ForgotPasswordPage";
           }
           case DB_ERROR:{
               model.addAttribute("error","internal error");
               return "ForgotPasswordPage";
           }
           case INVALID:{
               model.addAttribute("error","something went wrong ");
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
                model.addAttribute("identifier",identifier);
                return "ResetPasswordPage";
            }
            case "missMatch" :{
                model.addAttribute("error","password missMatch");
                model.addAttribute("identifier",identifier);
                return "ResetPasswordPage";
            }
            case "nullError" :{
                model.addAttribute("error","can not be  null");
                model.addAttribute("identifier",identifier);
                return "ResetPasswordPage";
            }
            case "invalidPassword" :{
                model.addAttribute("error","password is not valid ");
                model.addAttribute("identifier",identifier);
                return "ResetPasswordPage";
            }
        }
        return "LoginPage";
    }


}
