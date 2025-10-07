package com.xworkz.techRoute.restController;


import com.xworkz.techRoute.enums.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

    public LoginController(){
        System.out.println("No args of LoginController");
    }

    @PostMapping("login")
    public String login(String identifier, Role role , String password){
        System.err.println(identifier+"identifier");
        System.err.println(role+"role");
        System.err.println(password+"password");
        return "yes";
    }
}
