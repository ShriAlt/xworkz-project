package com.xworkz.techroute.service;

import com.xworkz.techroute.dto.SalesDTO;
import com.xworkz.techroute.enums.IssueCode;

public interface SalesService {

   IssueCode validateAndSaveSale(SalesDTO salesDTO);
}
