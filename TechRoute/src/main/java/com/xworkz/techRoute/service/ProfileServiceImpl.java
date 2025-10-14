package com.xworkz.techRoute.service;


import com.xworkz.techRoute.dto.LoginDto;
import com.xworkz.techRoute.dto.ProfileDto;
import com.xworkz.techRoute.entity.AdminLoginEntity;
import com.xworkz.techRoute.entity.RegisterEntity;
import com.xworkz.techRoute.entity.UserLoginEntity;
import com.xworkz.techRoute.repository.ProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProfileServiceImpl implements ProfileService {

    public ProfileServiceImpl(){
        System.out.println("no args of ProfileServiceImpl ");
    }

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String validateAndSave(ProfileDto dto) {
        if (profileRepository.checkByMail(dto.getEmail()) != null){
            return "emailExist";
        }
        if (profileRepository.checkByPhone(dto.getPhoneNumber()) != null){
            return "phoneNumberExist";
        }
        RegisterEntity registerEntity = new RegisterEntity();
        BeanUtils.copyProperties(dto, registerEntity);
        registerEntity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        boolean result = profileRepository.saveUser(registerEntity);
        if (result){
            return "all good";
        }
        return "dbError";
    }


    @Override
    public String login(LoginDto loginDto) {
        String identifier = loginDto.getIdentifier();
        if (identifier == null){
            return "invalid";
        }
       if (identifier.matches("^[6-9]\\d{9}$")){
          RegisterEntity registerEntity =  profileRepository.checkByPhone(identifier);
           System.err.println(registerEntity);
           return getResult(loginDto, registerEntity);
       }
       if (identifier.contains(".") && identifier.contains("@")){
         RegisterEntity registerEntity = profileRepository.checkByMail(identifier);
         return getResult(loginDto, registerEntity);
       }
        return "invalid";
    }


    private String getResult(LoginDto loginDto, RegisterEntity registerEntity) {
        if (registerEntity == null){
            return "noEmail";
        }
        if (registerEntity.getLoginAttempt()<3){
            if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), registerEntity.getPassword())){
                registerEntity.setLoginAttempt(registerEntity.getLoginAttempt()+1);
                profileRepository.updateProfile(registerEntity);
                return "passwordMisMatch";
            }
            registerEntity.setLoginAttempt(0);
          boolean update = profileRepository.updateProfile(registerEntity);
          if (!update){
              return "dbError";
          }
            switch (registerEntity.getRole()){
                case USER:{
                    UserLoginEntity userLoginEntity = new UserLoginEntity();
                    BeanUtils.copyProperties(loginDto, userLoginEntity);
                    userLoginEntity.setTimestamp(LocalDateTime.now());
                    if (!profileRepository.saveLoginInfo(userLoginEntity)){
                        return "dbError";
                    }
                    return "user";
                }
                case ADMIN:{
                    AdminLoginEntity adminLoginEntity = new AdminLoginEntity();
                    BeanUtils.copyProperties(loginDto,adminLoginEntity);
                    adminLoginEntity.setTimestamp(LocalDateTime.now());
                    if (!profileRepository.saveLoginInfo(adminLoginEntity)){
                        return "dbError";
                    }
                    return "admin";
                }
            }
        }
        return "accountLocked";
    }

    @Override
    public boolean checkMail(String mail) {
        if (mail == null){
            return false;
        }
       RegisterEntity registerEntity = profileRepository.checkByMail(mail);
        return registerEntity != null;
    }

    @Override
    public boolean checkPhone(String phone) {
        if (phone == null){
            return false;
        }
        RegisterEntity registerEntity = profileRepository.checkByPhone(phone);
        return registerEntity != null;
    }

}
