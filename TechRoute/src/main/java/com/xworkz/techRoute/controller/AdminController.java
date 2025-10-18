package com.xworkz.techRoute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    public AdminController(){
        System.out.println("no args of AdminController");
    }

    @GetMapping("viewProfile")
    public String viewProfile(){
        return "ViewPage";
    }
    @GetMapping("viewCustomer")
    public String viewCustomer(){
        return "CustomerDetails";
    }
    @GetMapping("addCustomer")
    public String addCustomer(){
        return "AddCustomer";
    }



}
