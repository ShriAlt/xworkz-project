package com.xworkz.techRoute.service;

import com.xworkz.techRoute.entity.RegisterEntity;
import com.xworkz.techRoute.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService{

    public ResetPasswordServiceImpl(){
        System.out.println("no args of ResetPasswordServiceImpl");
    }

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    MailService mailService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String sendAndSaveOtp(String identifier) {
        if (identifier == null){
            return "invalid";
        }
        if (identifier.matches("^[6-9]\\d{9}$")){
            RegisterEntity registerEntity =  profileRepository.checkByPhone(identifier);
            return validateAndSendOtp(registerEntity);
        }
        if (identifier.contains(".") && identifier.contains("@")){
            RegisterEntity registerEntity = profileRepository.checkByMail(identifier);
            return validateAndSendOtp(registerEntity);
        }
        return "invalid";
    }

    private String validateAndSendOtp(RegisterEntity registerEntity) {
        if (registerEntity == null){
            return "noPhoneNumber";
        }
        String otp = generateOtp();
        if (!mailService.sendOtp(registerEntity.getEmail(),otp)){
            return "sendError";
        }
        registerEntity.setOtp(bCryptPasswordEncoder.encode(otp));
        registerEntity.setOtpExpiryTime(LocalDateTime.now().plusMinutes(5));
//        System.err.println(registerEntity);
       boolean result = profileRepository.updateProfile(registerEntity);
       if (!result){
           return "dbError";
       }
        return "otpSent";
    }
    private String generateOtp(){
        Random random = new Random();
        return String.valueOf(100000+random.nextInt(999999));
    }

    @Override
    public String validateAndVerifyOtp(String identifier, String otp) {
        System.err.println(identifier);
        if (identifier == null){
            return "invalid";
        }
        if (identifier.matches("^[6-9]\\d{9}$")){
            RegisterEntity registerEntity =  profileRepository.checkByPhone(identifier);
            return verifyOtp(otp, registerEntity);
        }
        if (identifier.contains(".") && identifier.contains("@")){
            RegisterEntity registerEntity = profileRepository.checkByMail(identifier);
            return verifyOtp(otp, registerEntity);
        }else {
            return "invalidIdentifier";
        }
    }

    private String verifyOtp(String otp, RegisterEntity registerEntity) {
        if (registerEntity.getOtp() == null ||!registerEntity.getOtpExpiryTime().isAfter(LocalDateTime.now())){
            return "expired";
        }
        if (!bCryptPasswordEncoder.matches(otp, registerEntity.getOtp())){
            return "misMatch";
        }
        return "OK";
    }

    @Override
    public String ValidateAndUpdatePassword(String identifier, String password, String confirmPassword) {

        if (identifier == null){
            return "invalid";
        }
        if (password == null || confirmPassword == null){
            return "nullError";
        }
        if (identifier.matches("^[6-9]\\d{9}$")){
            RegisterEntity registerEntity =  profileRepository.checkByPhone(identifier);
            return checkAndUpdatePassword(registerEntity, password, confirmPassword);
        }
        if (identifier.contains(".") && identifier.contains("@")){
            RegisterEntity registerEntity = profileRepository.checkByMail(identifier);
            return checkAndUpdatePassword(registerEntity, password, confirmPassword);
        }
        return "invalid";
    }

    private String checkAndUpdatePassword(RegisterEntity registerEntity, String password, String confirmPassword) {
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")){
            return "invalidPassword";
        }
        if (!password.equals(confirmPassword)){
            return "missMatch";
        }
        registerEntity.setPassword(bCryptPasswordEncoder.encode(password));
        registerEntity.setLoginAttempt(0);
        boolean result =   profileRepository.updateProfile(registerEntity);
        if (!result){
            return "dbError";
        }
        return "allGood";
    }

}
