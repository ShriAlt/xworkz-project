package com.xworkz.techRoute.restController;

import com.xworkz.techRoute.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {
    @Autowired
    private AdminService service;

    @GetMapping("checkCustomerEmail")
    public ResponseEntity<String> checkCustomerEmail(String email){
        boolean exist = service.checkCustomerEmail(email);
        return ResponseEntity.ok(String.valueOf(exist));
    }
    @GetMapping("checkCustomerPhone")
    public ResponseEntity<String> checkCustomerPhone(String phone){
        boolean exist = service.checkCustomerPhone(phone);
        return ResponseEntity.ok(String.valueOf(exist));
    }
}
