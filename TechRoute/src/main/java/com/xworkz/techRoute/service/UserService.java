package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.entity.PurchaseEntity;
import com.xworkz.techRoute.enums.IssueCode;

import java.util.List;

public interface UserService {

    IssueCode validateAndSaveOrder(PurchaseDto dto);

    boolean validateAndAddGroupName(String productGroupName);

    List<String > fetchProducts();

    List<String> fetchDebitors();

    List<String> fetchCreditors();

    void saveCustomer(List<CustomerDto > dtos);

    void saveOrders(List<PurchaseDto > dtoList);

}
