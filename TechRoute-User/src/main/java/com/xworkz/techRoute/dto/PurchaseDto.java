package com.xworkz.techRoute.dto;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto implements Serializable {

//    @NotBlank
//    private String voucherType;

    @NotBlank
    private String customerName;

    @NotBlank
    private String productGroupName;

    @NotBlank
    @Size(max = 50)
    private String make;

    @NotBlank
    @Size(max = 50)
    private String model;

    @NotBlank
    @Size(max = 30)
    private String productCode;

    @NotBlank
    @Size(max = 100)
    private String itemName;

    @NotNull
    private Long openingValue;

    @NotNull
    @Min(0)
    private Integer openingBalance;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Long purchasePrice;

    @NotNull
    @Min(1)
    private Integer quantity;

    @FutureOrPresent
    private LocalDate orderDueDate;

    @NotBlank
    @Pattern(regexp = "pending|confirmed|shipped|cancelled", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String status;
}
