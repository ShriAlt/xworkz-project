package com.xworkz.techRoute.service;

import com.xworkz.techRoute.dto.CustomerDto;
import com.xworkz.techRoute.enums.IssueCode;

import java.util.List;

public interface AdminService {

    IssueCode validateAndSaveCustomer(CustomerDto dto);

    List<CustomerDto> viewCustomer();

    IssueCode validateAndUpdate(int id);
}
