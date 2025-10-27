package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminController {
    public AdminController(){
        System.out.println("no args of AdminController");
    }

    @Autowired
    private AdminService service;

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
    public String addCustomer( CustomerDto customerDto , BindingResult bindingResult , Model model){
//        if (bindingResult.hasErrors()){
//            model.addAttribute("error","fill your form correctly ");
//            return "AddCustomer";
//        }
         service.validateAndSaveCustomer(customerDto);
        return "AddCustomer";
    }

}
