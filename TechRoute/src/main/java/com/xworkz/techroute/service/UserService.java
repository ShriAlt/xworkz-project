package com.xworkz.techroute.service;

import com.xworkz.techroute.dto.PurchaseDto;
import com.xworkz.techroute.enums.IssueCode;

import java.util.List;

public interface UserService {

    IssueCode validateAndSaveOrder(PurchaseDto dto);

    boolean validateAndAddGroupName(String productGroupName);

    List<String > fetchProducts();

    List<String> fetchDebitors();

    List<String> fetchCreditors();

    void saveOrders(List<PurchaseDto > dtoList);

    String generateInvoiceForDownload(String id);

}
