package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.entity.PurchaseEntity;
import com.xworkz.techRoute.enums.IssueCode;

import java.util.List;

public interface AdminService {

    IssueCode validateAndSaveCustomer(CustomerDto dto);

    List<CustomerDto> viewCustomer();

    IssueCode validateAndUpdate(CustomerDto dto);

    CustomerDto fetchCustomer(int id);

    boolean deleteCustomer(int id);

    boolean checkCustomerEmail(String email);

    boolean checkCustomerPhone(String phone);

    List<PurchaseEntity> getAllPendingOrders();
}
