package com.xworkz.techRoute.service;

import com.xworkz.techRoute.controller.LoginController;
import com.xworkz.techRoute.dto.LoginDto;
import com.xworkz.techRoute.dto.UserDto;
import com.xworkz.techRoute.entity.LoginEntity;
import com.xworkz.techRoute.entity.UserEntity;
import com.xworkz.techRoute.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    public UserServiceImpl(){
        System.out.println("no args of UserServiceImpl ");
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String validateAndSave(UserDto dto) {
        if (userRepository.checkByMail(dto.getEmail()) != null){
            return "emailExist";
        }
        if (userRepository.checkByPhone(dto.getPhoneNumber()) != null){
            return "phoneNumberExist";
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(dto,userEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        boolean result = userRepository.saveUser(userEntity);
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
          UserEntity userEntity =  userRepository.checkByPhone(identifier);

           return getResult(loginDto, userEntity);
       }
       if (identifier.contains(".") && identifier.contains("@")){
         UserEntity userEntity = userRepository.checkByMail(identifier);
         return getResult(loginDto,userEntity);
       }
        return "invalid";
    }
    private String getResult(LoginDto loginDto, UserEntity userEntity) {
        if (userEntity == null){
            return "noEmail";
        }
        if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), userEntity.getPassword())){
            return "passwordMisMatch";
        }
        LoginEntity loginEntity = new LoginEntity();
        BeanUtils.copyProperties(loginDto,loginEntity);
        loginEntity.setTimestamp(LocalDateTime.now());
        System.err.println(loginEntity);
        if (!userRepository.saveLoginInfo(loginEntity)){
            return "dbError";
        }
        switch (userEntity.getRole()){
            case USER: return "user";
            case ADMIN: return "admin";
        }
        return "allGood";
    }

}
