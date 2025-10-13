package com.xworkz.techRoute.service;

import com.xworkz.techRoute.entity.RegisterEntity;
import com.xworkz.techRoute.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService{

    public ResetPasswordServiceImpl(){
        System.out.println("no args of ResetPasswordServiceImpl");
    }

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public String sendAndSaveOtp(String identifier) {
        if (identifier == null){
            return "invalid";
        }
        if (identifier.matches("^[6-9]\\d{9}$")){
            RegisterEntity registerEntity =  profileRepository.checkByPhone(identifier);

            return "";
        }
        if (identifier.contains(".") && identifier.contains("@")){
            RegisterEntity registerEntity = profileRepository.checkByMail(identifier);

            return "";
        }
        return "invalid";
    }
}
