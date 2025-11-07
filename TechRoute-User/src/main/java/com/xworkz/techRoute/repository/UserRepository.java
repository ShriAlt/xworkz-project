package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.ProductGroupEntity;

import java.util.List;

public interface UserRepository {


    List<ProductGroupEntity> findAll();
//
//    CustomerEntity fetchCustomerEntity(int id);
//
//    boolean deleteCustomer(int id);
//
//    CustomerEntity fetchCustomerEntityByMail(String email);
//
//    CustomerEntity fetchCustomerEntityByNumber(String number);

    <T> boolean  save(T entity);
}
