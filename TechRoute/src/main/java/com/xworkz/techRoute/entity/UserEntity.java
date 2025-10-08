package com.xworkz.techRoute.entity;

import com.xworkz.techRoute.enums.Role;

import javax.persistence.*;


@Entity
@Table(name = "Users_Table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private Role role;
}
