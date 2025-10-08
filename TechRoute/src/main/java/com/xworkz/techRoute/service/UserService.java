package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.UserDto;

public interface UserService {

    boolean validateAndSave(UserDto dto);
}
