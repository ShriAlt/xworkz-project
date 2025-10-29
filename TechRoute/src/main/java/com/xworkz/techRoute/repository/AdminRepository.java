package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.CustomerEntity;

import java.util.List;

public interface AdminRepository {
    List<CustomerEntity> findAll();

    CustomerEntity fetchCustomerEntity(int id);

    boolean deleteCustomer(int id);

    CustomerEntity fetchCustomerEntityByMail(String email);

    CustomerEntity fetchCustomerEntityByNumber(String number);
}
