package com.xworkz.techRoute.restController;

import com.xworkz.techRoute.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("add-product")
    public ResponseEntity<String> addProductGroup(String productGroupName){
        boolean result = userService.validateAndAddGroupName(productGroupName);
        if(result){
        return ResponseEntity.status(HttpStatus.CREATED).body("product group added");
        }
        return  ResponseEntity.status(HttpStatus.CREATED).body("couldn't add ");
    }

    @GetMapping("fetch-products")
    public List<String> fetchProduct(){
       return userService.fetchProducts();
    }

    @GetMapping("/fetch-debitors")
    public List<String> findAllDebitors(){
        return userService.fetchDebitors();
    }

    @GetMapping("fetch-creditors")
    public List<String> findAllCreditors(){
        return userService.fetchCreditors();
    }

//    @PostMapping("addCustomer")
//    public ResponseEntity<String> addCustomer(@RequestBody List<CustomerDto> dtos){
//         userService.saveCustomer(dtos);
//        return  ResponseEntity.status(HttpStatus.CREATED).body("couldn't add ");
//    }
}
