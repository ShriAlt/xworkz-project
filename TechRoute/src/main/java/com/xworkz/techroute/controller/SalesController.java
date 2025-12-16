package com.xworkz.techroute.controller;

import com.xworkz.techroute.dto.SalesDTO;
import com.xworkz.techroute.enums.IssueCode;
import com.xworkz.techroute.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SalesController {

    @Autowired
    SalesService salesService;

    @PostMapping("/sales")
    public String placeSale(SalesDTO salesDTO, Model model) {

        IssueCode issueCode = salesService.validateAndSaveSale(salesDTO);
        switch (issueCode) {
            case OK:
                model.addAttribute("message", "Sale placed successfully!");
                model.addAttribute("alertClass", "alert-success");
                break;

            case PRODUCT_NOT_FOUND:
                model.addAttribute("message", "Product not found. Please check product code.");
                model.addAttribute("alertClass", "alert-danger");
                break;

            case STOCK_NOT_FOUND:
                model.addAttribute("message", "No stock record found for this product.");
                model.addAttribute("alertClass", "alert-danger");
                break;

            case INVALID_QUANTITY:
                model.addAttribute("message", "Sale quantity is invalid.");
                model.addAttribute("alertClass", "alert-warning");
                break;

            case INSUFFICIENT_STOCK:
                model.addAttribute("message", "Not enough stock available for this sale.");
                model.addAttribute("alertClass", "alert-warning");
                break;

            case DB_ERROR:
                model.addAttribute("message", "Database error occurred while saving sale.");
                model.addAttribute("alertClass", "alert-danger");
                break;

            case NULL_ERROR:
                model.addAttribute("message", "Null value encountered in sale data.");
                model.addAttribute("alertClass", "alert-danger");
                break;

            case INVALID_IDENTIFIER:
                model.addAttribute("message", "Invalid product identifier provided.");
                model.addAttribute("alertClass", "alert-danger");
                break;

            default:
                model.addAttribute("message", "Unexpected error occurred.");
                model.addAttribute("alertClass", "alert-danger");
                break;
        }
        return "OrdersPage";
    }

}
