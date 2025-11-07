package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.PurchaseDto;
import com.xworkz.techRoute.enums.IssueCode;

public interface UserService {

    IssueCode validateAndSaveOrder(PurchaseDto dto);

    boolean validateAndAddGroupName(String productGroupName);
}
