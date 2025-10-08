package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.UserDto;
import com.xworkz.techRoute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    public UserServiceImpl(){
        System.out.println("no args of UserServiceImpl ");
    }
@Autowired
    UserRepository userRepository;


    @Override
    public boolean validateAndSave(UserDto dto) {

        return false;
    }
}
