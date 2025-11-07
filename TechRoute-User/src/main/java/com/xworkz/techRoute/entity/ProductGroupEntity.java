package com.xworkz.techRoute.entity;


import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@NamedQuery(name = "findAll",
            query = "select entity from ProductGroupEntity entity")
public class ProductGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productGroupName;
}
