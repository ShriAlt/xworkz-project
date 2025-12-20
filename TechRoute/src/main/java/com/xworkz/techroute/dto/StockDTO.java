package com.xworkz.techroute.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class StockDTO {

    private Integer stockId;
    private Integer quantity;
    private Integer openingValue;
    private Double purchasePrice;
    private String warehouse;
    private ProductMasterDTO productMasterDTO;
    private LocalDateTime lastUpdated;

    public StockDTO(LocalDateTime lastUpdated, String warehouse, Double purchasePrice, Integer openingValue, Integer quantity, Integer stockId) {
        this.lastUpdated = lastUpdated;
        this.warehouse = warehouse;
        this.purchasePrice = purchasePrice;
        this.openingValue = openingValue;
        this.quantity = quantity;
        this.stockId = stockId;
    }
}
