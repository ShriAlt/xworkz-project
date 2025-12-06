package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.dto.ProductMasterDTO;
import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.enums.IssueCode;
import com.xworkz.techRoute.enums.OrderStatus;

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
