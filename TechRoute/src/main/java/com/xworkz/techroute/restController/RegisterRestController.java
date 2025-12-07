package com.xworkz.techroute.restController;


import com.xworkz.techroute.dto.ProfileDto;
import com.xworkz.techroute.enums.IssueCode;
import com.xworkz.techroute.service.ProfileService;
import com.xworkz.techroute.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
public class RegisterRestController {

    public RegisterRestController(){
        System.out.println("No args of RegisterRestController");
    }

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ResetPasswordService resetPasswordService;

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
    @PostMapping("resendOtp")
    public ResponseEntity<String> resendOtp(String identifier, Model model){
        switch (resetPasswordService.resendOtp(identifier)){
            case NO_PHONE_NUMBER:
            case SEND_ERROR:
            case DB_ERROR:
            case INVALID: {
                model.addAttribute("error","couldn't send otp try again after some time ");
                return ResponseEntity.internalServerError().body("not sent");
            }
        }
        return ResponseEntity.ok("sent");
    }

}
