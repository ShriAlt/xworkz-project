package com.xworkz.techRoute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    public AdminController(){
        System.out.println("no args of AdminController");
    }

    @GetMapping("viewProfile")
    public String viewProfilePage(){
        return "ViewPage";
    }
    @GetMapping("viewCustomer")
    public String viewCustomerPage(){
        return "CustomerDetails";
    }
    @GetMapping("addCustomer")
    public String addCustomerPage(){
        return "AddCustomer";
    }

    @PostMapping("AddCustomer")
    public String addCustomer(){

        return "AddCustomer";
    }

}
