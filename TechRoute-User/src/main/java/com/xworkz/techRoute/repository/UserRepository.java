package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.entity.ProductGroupEntity;

import java.util.List;

public interface UserRepository{


    List<ProductGroupEntity> findAllProductGroupName();

    <T> boolean  save(T entity);

      List<CustomerEntity> findAllCustomer();

      CustomerEntity findByName(String name);

}
