package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    @GetMapping("viewProfilePage")
    public String viewProfilePage(){
        return "ViewPage";
    }
    @GetMapping("updateCustomerPage")
    public String updateCustomerPage(int id , Model model){
        CustomerDto  dto =  service.fetchCustomer(id);
        model.addAttribute("dto",dto);
        return "UpdateCustomerPage";
    }
    @GetMapping("viewCustomerPage")
    public String viewCustomerPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "9") int size, Model model) {
        pagination(page, size, model);
        return "CustomerDetails";
    }
    @GetMapping("adminHome")
    public String  adminHonePage(){
        return "AdminHome";
    }
    @PostMapping("addCustomer")
    public String addCustomer( CustomerDto customerDto , BindingResult bindingResult , Model model){
        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(System.err::println);
            model.addAttribute("error","fill your form correctly ");
            return "AddCustomer";
        }
        switch (service.validateAndSaveCustomer(customerDto)){
            case INVALID :
            case DB_ERROR: {
                model.addAttribute("error","couldn't save customer");
                return "AddCustomer";
            }
            case PHONE_EXIST:{
                model.addAttribute("error","number exist");
                return "AddCustomer";
            }
            case EMAIL_EXIST:{
                model.addAttribute("error","email exist");
                return "AddCustomer";
            }
            default: {
                model.addAttribute("error","customer saved!!!");
                return "AddCustomer";
            }
        }
    }
    @PostMapping("UpdateCustomer")
     public String updateCustomer(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, @Valid CustomerDto dto , BindingResult bindingResult , Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("error","fill your form correctly ");
            model.addAttribute("dto",dto);
            return "UpdateCustomerPage";
        }
        System.err.println(dto.getId()+"==========================================");
        switch (service.validateAndUpdate(dto)){
            case INVALID :
            case DB_ERROR: {
                model.addAttribute("error","couldn't update customer");
                return "UpdateCustomerPage";
            }
            case PHONE_EXIST:{
                model.addAttribute("error","number exist");
                return "UpdateCustomerPage";
            }
            case EMAIL_EXIST:{
                model.addAttribute("error","email exist");
                return "UpdateCustomerPage";
            }
            default: {
                model.addAttribute("error","customer updated!!!");
                pagination(page,size,model);
                return "CustomerDetails";
            }
        }
   }
    @GetMapping("deleteCustomer")
    public String deleteCustomer(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, Model model ,int id){
        if(!service.deleteCustomer(id)){
            pagination(page, size, model);
            model.addAttribute("error", "could not delete customer ");
            return "CustomerDetails";
        }
        pagination(page, size, model);
        model.addAttribute("error", "deleted customer ");
        return "CustomerDetails";
    }

    private void pagination(int page, int size, Model model) {
        List<CustomerDto> allCustomers = service.viewCustomer();
        int totalCustomers = allCustomers.size();
        int start = (page -1) * size;
        int end = Math.min(start + size, totalCustomers);
        List<CustomerDto> paginatedList = allCustomers.subList(start, end);
        model.addAttribute("listOfCustomer", paginatedList);
        model.addAttribute("totalCustomers", totalCustomers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) totalCustomers / size));
        model.addAttribute("startIndex", start+1);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentPage", page);
    }
}

