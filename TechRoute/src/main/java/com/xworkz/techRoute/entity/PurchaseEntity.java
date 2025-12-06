package com.xworkz.techRoute.entity;

import com.xworkz.techRoute.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery( name = "findAllOrders",
        query = "SELECT entity FROM PurchaseEntity entity"

)
@NamedQuery( name = "findOrderById",
        query = "SELECT entity FROM PurchaseEntity entity where entity.id =:id"

)
@Builder
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
    private OrderStatus orderStatus;
}
