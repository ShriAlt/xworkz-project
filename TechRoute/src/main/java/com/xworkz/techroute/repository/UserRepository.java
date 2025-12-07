package com.xworkz.techroute.repository;

import com.xworkz.techroute.entity.CustomerEntity;
import com.xworkz.techroute.entity.ProductGroupEntity;

import java.util.List;

public interface UserRepository {


    List<ProductGroupEntity> findAllProductGroupName();

      List<CustomerEntity> findAllCustomer();

      CustomerEntity findByCustomerName(String name);

}
