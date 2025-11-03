package com.xworkz.techRoute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {


@GetMapping("salesPage")
    public String sales(){
        return "SalesPage";
    }
    @GetMapping("purchasePage")
    public String purchasePage(){
        return "PurchasePage";
    }





}
