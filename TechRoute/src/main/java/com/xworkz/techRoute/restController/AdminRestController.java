package com.xworkz.techRoute.restController;

import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("getNotifications")
    public ResponseEntity<Integer> getPendingOrdersCount(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllPendingOrders().size());
    }
    @GetMapping("viewPendingOrders")
    public List<PurchaseDto> getPendingOrders(Model model) {
        return service.getAllPendingOrders();
    }

}
