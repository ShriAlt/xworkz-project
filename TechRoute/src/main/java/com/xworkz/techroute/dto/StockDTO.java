package com.xworkz.techroute.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private Integer stockId;
    private Integer quantity;
    private Integer openingValue;
    private Double purchasePrice;
    private String warehouse;
    private LocalDateTime lastUpdated;


}
