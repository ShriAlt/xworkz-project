package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.CustomerDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    public AdminController(){
        System.out.println("no args of AdminController");
    }

    @GetMapping("viewProfilePage")
    public String viewProfilePage(){
        return "ViewPage";
    }
    @GetMapping("viewCustomerPage")
    public String viewCustomerPage(){
        return "CustomerDetails";
    }
    @GetMapping("addCustomerPage")
    public String addCustomerPage(){
        return "AddCustomer";
    }

    @PostMapping("addCustomer")
    public String addCustomer(CustomerDto customerDto){
        System.out.println("workinng");
        System.err.println(customerDto.toString());
        return "AddCustomer";
    }

}
