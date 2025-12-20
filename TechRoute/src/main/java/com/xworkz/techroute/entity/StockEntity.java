package com.xworkz.techroute.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stocks")
@Data
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Integer stockId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "opening_value", nullable = false)
    private Integer openingValue;

    @Column(name = "purchase_price", precision = 10, scale = 2)
    private Double purchasePrice;

    @Column(name = "warehouse", length = 100)
    private String warehouse;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private ProductMasterEntity product;

}
