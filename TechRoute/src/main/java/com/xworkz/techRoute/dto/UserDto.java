package com.xworkz.techRoute.dto;

import com.xworkz.techRoute.enums.Role;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    public UserDto(){
        System.out.println("no args of UserDto ");
    }

    private String firstName;

    private String lastName;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phoneNumber;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    @NotNull(message = "please tell the role")
    private Role role;

}
