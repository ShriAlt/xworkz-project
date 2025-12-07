package com.xworkz.techroute.service;

import com.xworkz.techroute.dto.LoginDto;
import com.xworkz.techroute.dto.ProfileDto;
import com.xworkz.techroute.enums.IssueCode;

public interface ProfileService {

    IssueCode validateAndSave(ProfileDto dto);

    IssueCode login(LoginDto loginDto);

    boolean checkMail(String mail);

    boolean checkPhone(String phone);

    ProfileDto displayProfile(String identifier);

}
