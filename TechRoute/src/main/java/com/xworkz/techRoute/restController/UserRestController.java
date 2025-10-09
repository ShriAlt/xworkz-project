package com.xworkz.techRoute.restController;


import com.xworkz.techRoute.dto.UserDto;
import com.xworkz.techRoute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserRestController {

    public UserRestController(){
        System.out.println("No args of UserRestController");
    }

    @Autowired
    private UserService userService;

    @PostMapping("userRegister")
    public ResponseEntity<String> userRegister(UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("has Errors in your data ");
        }
        String result =  userService.validateAndSave(userDto);
        switch (result) {
            case "emailExist":
                return ResponseEntity.status(HttpStatus.CONFLICT).body("mail exist");
            case "phoneNumberExist":
                return ResponseEntity.status(HttpStatus.CONFLICT).body("phone number exist");
            case "dbError":
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("developer error ");
        }
        return ResponseEntity.ok("Registered : " + userDto.getEmail()+" !!!!");
    }
}
