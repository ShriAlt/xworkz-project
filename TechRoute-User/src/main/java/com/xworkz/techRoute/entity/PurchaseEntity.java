package com.xworkz.techRoute.entity;

import com.xworkz.techRoute.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String customerName;

    private String productGroupName;

    private String companyName;

    private String model;

    private String productCode;

    private String productName;

    private Long openingValue;

    private Long purchasePrice;

    private Integer quantity;

    private Integer stockInHand;

    private String  orderDueDate;

    @Enumerated(EnumType.STRING)
    private Status status;
}
