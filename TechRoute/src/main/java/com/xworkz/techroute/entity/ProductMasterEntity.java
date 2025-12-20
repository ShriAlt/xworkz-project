package com.xworkz.techroute.entity;

import com.xworkz.techroute.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_master")
@Data
@NamedQuery(
        name = "fetchAllProductByGroupName",
        query = "SELECT p FROM ProductMasterEntity p JOIN FETCH p.stocks s WHERE p.productGroupName = :groupName"
)
public class ProductMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column( name = "product_code", nullable = false, unique = true, length = 30)
    private String productCode;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column( name = "product_group_name", nullable = false, length = 50)
    private String productGroupName;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "company_name", length = 50)
    private String companyName;

    @Column(name = "variant_attributes", length = 100)
    private String variantAttributes;

    @Column(name = "default_purchase_price", precision = 10, scale = 2)
    private Double defaultPurchasePrice;

    @Column(name = "default_sale_price", precision = 10, scale = 2)
    private Double defaultSalePrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10)
    private Status status = Status.ACTIVE;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ProductMasterEntity(){
        this.createdAt=LocalDateTime.now();
    }

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private java.util.List<StockEntity> stocks;
}