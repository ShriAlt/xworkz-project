package com.xworkz.techroute.dto;

import com.xworkz.techroute.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto implements Serializable {

    int id;

    @NotBlank
    private String customerName;

    @NotBlank
    private String productGroupName;

    @NotBlank
    @Size(max = 50)
    private String companyName;

    @NotBlank
    @Size(max = 50)
    private String model;

    @NotBlank
    @Size(max = 30)
    private String productCode;

    @NotBlank
    @Size(max = 100)
    private String productName;

    @NotNull
    private Long openingValue;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Long purchasePrice;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    @Min(1)
    private Integer stockInHand;

    @NotBlank
    private String orderDueDate;

    @NotNull
    private OrderStatus orderStatus;
}
