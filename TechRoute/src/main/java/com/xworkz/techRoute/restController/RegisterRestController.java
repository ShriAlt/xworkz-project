package com.xworkz.techRoute.restController;


import com.xworkz.techRoute.dto.ProfileDto;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class RegisterRestController {

    public RegisterRestController(){
        System.out.println("No args of RegisterRestController");
    }

    @Autowired
    private ProfileService profileService;

    @PostMapping("profileRegister")
    public ResponseEntity<String> profileRegister(@Valid ProfileDto profileDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("fill the valid data ");
        }
        IssueCode result =  profileService.validateAndSave(profileDto);
        switch (result) {
            case EMAIL_EXIST:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("mail exist");
            case PHONE_EXIST:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("phone number exist");
            case DB_ERROR:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("developer error ");
        }
        return ResponseEntity.ok("Registered : " + profileDto.getEmail()+" !!!!");
    }

    @GetMapping("checkEmail")
    public ResponseEntity<String> checkEmail(String email){
        boolean exist = profileService.checkMail(email);
        return ResponseEntity.ok(String.valueOf(exist));
    }

    @GetMapping("checkPhone")
    public ResponseEntity<String> checkPhone(String phone){
        boolean exist = profileService.checkPhone(phone);
        return ResponseEntity.ok(String.valueOf(exist));
    }
}
