package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.UserDto;
import com.xworkz.techRoute.entity.UserEntity;
import com.xworkz.techRoute.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
