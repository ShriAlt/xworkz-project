package com.xworkz.techRoute.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    public LoginDto(){
        System.out.println("no args of LoginDto");
    }

    private String identifier;

    private String password;

}
