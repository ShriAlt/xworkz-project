package com.xworkz.techroute.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedQuery(name = "findAllProductGroupName",
            query = "select entity from ProductGroupEntity entity")
public class ProductGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productGroupName;
}
