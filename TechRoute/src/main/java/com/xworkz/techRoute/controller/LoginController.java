package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.LoginDto;
import com.xworkz.techRoute.service.UserService;
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
    private UserService userService;

    @GetMapping("loginPage")
    public String loginPage(){
        System.out.println("working");
        return "LoginPage";
    }

    @PostMapping("login")
    public String login(LoginDto dto , Model model){
        if (dto!=null) {
            String result = userService.login(dto);
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
            }
        }
        return "LoginPage";
    }

}
