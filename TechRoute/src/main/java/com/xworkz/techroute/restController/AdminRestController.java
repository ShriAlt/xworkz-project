package com.xworkz.techroute.restController;

import com.xworkz.techroute.dto.ProductMasterDTO;
import com.xworkz.techroute.dto.PurchaseDto;
import com.xworkz.techroute.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("AddProducts-ui")
    public String addProducts(@RequestBody List<ProductMasterDTO> dtos){
        dtos.forEach(dto ->service.addProduct(dto));
        return "hello";
    }
}
