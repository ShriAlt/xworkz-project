package com.xworkz.techroute.controller;

import com.xworkz.techroute.dto.StockDTO;
import com.xworkz.techroute.service.SalesService;
import com.xworkz.techroute.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class UserSaleController {

    private  final UserService userService;
    public UserSaleController(UserService userService ){
        this.userService=userService;
    }

    @GetMapping("stockPage")
    public String stockPage(Model model){
        List<StockDTO> stockDTOS = userService.fetchAllStock();

        model.addAttribute("stockDto",stockDTOS);
        return "StockPage";
    }

}
