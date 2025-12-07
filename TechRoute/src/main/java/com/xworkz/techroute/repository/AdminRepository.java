package com.xworkz.techroute.repository;

import com.xworkz.techroute.entity.CustomerEntity;
import com.xworkz.techroute.entity.PurchaseEntity;

import java.util.List;

public interface AdminRepository {
    List<CustomerEntity> findAllCustomer();

    CustomerEntity fetchCustomerEntity(int id);

    boolean deleteCustomer(int id);

    CustomerEntity fetchCustomerEntityByMail(String email);

    CustomerEntity fetchCustomerEntityByNumber(String number);

    List<PurchaseEntity> findAllOrders();

    PurchaseEntity findOrderById(int id);
}
