package com.xworkz.techroute.dto;

import com.xworkz.techroute.enums.Status;
import lombok.Data;

@Data
public class ProductMasterDTO {

    private String productCode;
    private String productName;
    private String productGroupName;
    private String model;
    private String companyName;
    private String variantAttributes;
    private Double defaultPurchasePrice;
    private Double defaultSalePrice;
    private Status status;


}

