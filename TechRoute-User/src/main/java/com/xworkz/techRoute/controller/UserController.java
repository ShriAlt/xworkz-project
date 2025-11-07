package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("salesPage")
    public String sales(){
        return "SalesPage";
    }
    @GetMapping("purchasePage")
    public String purchasePage(){
        return "PurchasePage";
    }

    @PostMapping("purchase")
    public String purchase(@Valid PurchaseDto purchaseDto , BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("error","Has errors");
            return "PurchasePage";
        }
        IssueCode issueCode = userService.validateAndSaveOrder(purchaseDto);

        return "PurchasePage";
    }
}
