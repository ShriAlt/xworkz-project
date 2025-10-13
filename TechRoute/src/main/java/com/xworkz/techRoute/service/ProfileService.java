package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.LoginDto;
import com.xworkz.techRoute.dto.ProfileDto;

public interface ProfileService {

    String validateAndSave(ProfileDto dto);

    String login(LoginDto loginDto);

   boolean checkMail(String mail);

   boolean checkPhone(String phone);

   String verifyAndSendOtp(String identifier);
}
