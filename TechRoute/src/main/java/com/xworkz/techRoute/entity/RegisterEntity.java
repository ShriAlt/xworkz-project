package com.xworkz.techRoute.entity;

import com.xworkz.techRoute.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "register_details")
@Data
@NamedQuery(
        name = "findByMail",
        query = "SELECT u FROM RegisterEntity u WHERE u.email = :email"
)
@NamedQuery(
        name = "findByPhone",
        query = "SELECT u FROM RegisterEntity u WHERE u.phoneNumber = :phoneNumber"
)
public class RegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private int loginAttempt;

    private String otp;

    private LocalDateTime otpExpiryTime;
}
