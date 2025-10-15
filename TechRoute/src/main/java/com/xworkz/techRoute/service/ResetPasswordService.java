package com.xworkz.techRoute.service;


import com.xworkz.techRoute.enums.IssueCode;

public interface ResetPasswordService {

    IssueCode sendAndSaveOtp(String identifier);

    String validateAndVerifyOtp(String identifier , String otp);

    String ValidateAndUpdatePassword(String identifier , String password , String confirmPassword);

    IssueCode resendOtp(String identifier);
}
