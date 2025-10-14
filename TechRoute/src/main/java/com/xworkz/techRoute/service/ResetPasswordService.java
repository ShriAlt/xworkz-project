package com.xworkz.techRoute.service;


public interface ResetPasswordService {

    String sendAndSaveOtp(String identifier);

    String validateAndVerifyOtp(String identifier , String otp);

    String ValidateAndUpdatePassword(String identifier , String password , String confirmPassword);
}
