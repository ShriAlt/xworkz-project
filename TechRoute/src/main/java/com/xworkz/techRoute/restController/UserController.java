package com.xworkz.techRoute.restController;


import com.xworkz.techRoute.dto.UserDto;
import com.xworkz.techRoute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    public UserController(){
        System.out.println("No args of UserController");
    }

    @Autowired
    private UserService userService;

    @PostMapping("userRegister")
    public String userRegister(UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "Invalid Data";
        }
        boolean result =  userService.validateAndSave(userDto);
        if (!result){
            return "Invalid Data";
        }
        return "Registered";
    }
}
