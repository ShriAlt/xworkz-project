package com.xworkz.techRoute.controller;

import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.service.AdminService;
import com.xworkz.techRoute.service.UserService;
import com.xworkz.techRoute.util.PdfGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    private final AdminService adminService;

    public UserController(UserService userService,AdminService adminService){
        this.userService=userService;
        this.adminService=adminService;
    }

    @GetMapping("purchasePage")
    public String purchasePage(){
        return "OrdersPage";
    }

    @GetMapping("userHomePage")
    public String userHomePage(){
        return "UserHome";
    }

    @PostMapping("purchase")
    public String purchase(@Valid PurchaseDto purchaseDto , BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("error","Has errors");
            return "OrdersPage";
        }
        IssueCode issueCode = userService.validateAndSaveOrder(purchaseDto);
        switch (issueCode){
            case NAME_NAME_EXIST:{
                model.addAttribute("error", "name not exist");
                return "OrdersPage";
            }
            case OK:{
                model.addAttribute("error", "added");
                return "OrdersPage";
            }
            default:{
                model.addAttribute("error", "something went wrong");
                return "OrdersPage";
            }
        }
    }
    @GetMapping("viewAllOrders")
    public String viewAllOrders(Model model){
        List<PurchaseDto> allOrders = adminService.getAllOrders();
        model.addAttribute("allOrders",allOrders);
        return "userViewAllOrdersPage";
    }

    @GetMapping("downloadInvoice")
    public void generateInvoice(String id,Model model, HttpServletResponse response){
        List<PurchaseDto> allOrders = adminService.getAllOrders();
        model.addAttribute("allOrders",allOrders);
        String htmlPage =  userService.generateInvoiceForDownload(id);
        byte[] pdfBytes = PdfGenerator.htmlToPdf(htmlPage);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=invoice_" + id + ".pdf");
        try {
            response.getOutputStream().write(pdfBytes);
            response.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println();
        }
    }
}
