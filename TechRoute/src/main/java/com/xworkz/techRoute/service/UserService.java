package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.LoginDto;
import com.xworkz.techRoute.dto.UserDto;

public interface UserService {

    String validateAndSave(UserDto dto);

    String login(LoginDto loginDto);

   boolean checkMail(String mail);

   boolean checkPhone(String phone);
}
