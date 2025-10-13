package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.LoginDto;
import com.xworkz.techRoute.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    public LoginController(){
        System.out.println("no args LoginController");
    }

    @Autowired
    private ProfileService profileService;

    @GetMapping("loginPage")
    public String loginPage(){
        return "LoginPage";
    }

    @PostMapping("login")
    public String login(LoginDto dto , Model model){
        if (dto!=null) {
            String result = profileService.login(dto);
            switch (result) {
                case "invalid": {
                    return "LoginPage";
                }
                case "noEmail": {
                    model.addAttribute("identifier",dto.getIdentifier());
                    model.addAttribute("error", "please use registered phone number or email  ");
                    return "LoginPage";
                }
                case "passwordMisMatch": {
                    model.addAttribute("identifier",dto.getIdentifier());
                    model.addAttribute("passwordError", "password doesn't match ");
                    return "LoginPage";
                }
                case "dbError": {
                    model.addAttribute("identifier",dto.getIdentifier());
                    model.addAttribute("error", "internal db error");
                    return "LoginPage";
                }
                case "user": {
                    return "UserHome";
                }
                case "admin": {
                    return "AdminHome";
                }
                case "accountLocked":{
                    model.addAttribute("locked","your account is locked please reset your password");
                    model.addAttribute("identifier",dto.getIdentifier());
                    return "ForgotPasswordPage";
                }
            }
        }
        return "LoginPage";
    }

}
