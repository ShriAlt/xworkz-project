package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.LoginDto;
import com.xworkz.techRoute.dto.ProfileDto;
import com.xworkz.techRoute.enums.IssueCode;

public interface ProfileService {

    IssueCode validateAndSave(ProfileDto dto);

    IssueCode login(LoginDto loginDto);

    boolean checkMail(String mail);

    boolean checkPhone(String phone);

    ProfileDto displayProfile(String identifier);

}
