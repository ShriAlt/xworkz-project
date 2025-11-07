package com.xworkz.techRoute.restController;

import com.xworkz.techRoute.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
