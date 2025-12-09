package com.xworkz.techroute.dto;

import com.xworkz.techroute.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMasterDTO {

    private Integer productId;
    private String productCode;
    private String productName;
    private String productGroupName;
    private String model;
    private String companyName;
    private String variantAttributes;
    private Double defaultPurchasePrice;
    private Double defaultSalePrice;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<StockDTO> stocks;


}

