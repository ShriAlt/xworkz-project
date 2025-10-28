package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {
    public AdminController(){
        System.out.println("no args of AdminController");
    }

    @Autowired
    private AdminService service;

    @GetMapping("addCustomerPage")
    public String addCustomerPage(){
        return "AddCustomer";
    }

    @PostMapping("addCustomer")
    public String addCustomer( CustomerDto customerDto , BindingResult bindingResult , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("error","fill your form correctly ");
            return "AddCustomer";
        }
         service.validateAndSaveCustomer(customerDto);
        return "AddCustomer";
    }
    @GetMapping("viewProfilePage")
    public String viewProfilePage(){
        return "ViewPage";
    }

    @GetMapping("/viewCustomerPage")
    public String viewCustomerPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, Model model) {
        List<CustomerDto> allCustomers = service.viewCustomer();

        int totalCustomers = allCustomers.size();

        int start = (page-1) * size;
        int end = Math.min(start + size, totalCustomers);

        List<CustomerDto> paginatedList = allCustomers.subList(start, end);

        model.addAttribute("listOfCustomer", paginatedList);
        model.addAttribute("totalCustomers", totalCustomers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) totalCustomers / size));
        model.addAttribute("startIndex", start+1);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentPage", page);
        return "CustomerDetails";
    }

    @GetMapping("updateCustomer")
    public String updateCustomer(int id){

        return "CustomerDetails";
    }
    @GetMapping("deleteCustomer")
    public String deleteCustomer(int id){

        return "CustomerDetails";
    }
}

