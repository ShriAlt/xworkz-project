package com.xworkz.techRoute.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "admin_login_details")
public class AdminLoginEntity implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "admin")
        private String identifier;

        private LocalDateTime timestamp;


}
