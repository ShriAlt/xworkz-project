package com.xworkz.techroute.service;

import com.xworkz.techroute.dto.CustomerDto;
import com.xworkz.techroute.dto.ProductMasterDTO;
import com.xworkz.techroute.dto.PurchaseDto;
import com.xworkz.techroute.enums.IssueCode;
import com.xworkz.techroute.enums.OrderStatus;

import java.util.List;

public interface AdminService {

    IssueCode validateAndSaveCustomer(CustomerDto dto);

    List<CustomerDto> viewCustomer();

    IssueCode validateAndUpdate(CustomerDto dto);

    CustomerDto fetchCustomer(int id);

    boolean deleteCustomer(int id);

    boolean checkCustomerEmail(String email);

    boolean checkCustomerPhone(String phone);

    List<PurchaseDto> getAllPendingOrders();

    PurchaseDto getOrderById(String  id);

    boolean updateStatus(String id, OrderStatus orderStatus);

    List<PurchaseDto> getAllOrders();

    IssueCode addProduct(ProductMasterDTO productMasterDTO);

}
