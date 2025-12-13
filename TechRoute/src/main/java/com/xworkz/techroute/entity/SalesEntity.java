package com.xworkz.techroute.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class SalesEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "sale_id")
        private Long saleId;

        // Customer (creditor who buys from you)
        @Column(name = "customer_name", nullable = false, length = 100)
        private String customerName;

        // Product details
        @Column(name = "product_group_name", nullable = false, length = 50)
        private String productGroupName;

        @Column(name = "product_name", nullable = false, length = 100)
        private String productName;

        @Column(name = "company_name", nullable = false, length = 50)
        private String companyName;

        @Column(name = "model", nullable = false, length = 50)
        private String model;

        @Column(name = "product_code", nullable = false, length = 30)
        private String productCode;

        // Stock + sale info
        @Column(name = "available_stock")
        private Integer availableStock;

        @Column(name = "sale_quantity", nullable = false)
        private Integer saleQuantity;

        @Column(name = "sale_price", nullable = false)
        private Double salePrice;

        @Column(name = "order_status", nullable = false, length = 20)
        private String orderStatus; // PENDING / CONFIRMED / CANCELLED / SHIPPED

        @Column(name = "created_at", nullable = false)
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        // Constructors
        public SalesEntity() {}

        public SalesEntity(String customerName, String productGroupName, String productName,
                           String companyName, String model, String productCode,
                           Integer availableStock, Integer saleQuantity, Double salePrice,
                           String orderStatus, LocalDateTime createdAt) {
            this.customerName = customerName;
            this.productGroupName = productGroupName;
            this.productName = productName;
            this.companyName = companyName;
            this.model = model;
            this.productCode = productCode;
            this.availableStock = availableStock;
            this.saleQuantity = saleQuantity;
            this.salePrice = salePrice;
            this.orderStatus = orderStatus;
            this.createdAt = createdAt;
        }

        // Getters and setters
        public Long getSaleId() { return saleId; }
        public void setSaleId(Long saleId) { this.saleId = saleId; }

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public String getProductGroupName() { return productGroupName; }
        public void setProductGroupName(String productGroupName) { this.productGroupName = productGroupName; }

        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }

        public String getCompanyName() { return companyName; }
        public void setCompanyName(String companyName) { this.companyName = companyName; }

        public String getModel() { return model; }
        public void setModel(String model) { this.model = model; }

        public String getProductCode() { return productCode; }
        public void setProductCode(String productCode) { this.productCode = productCode; }

        public Integer getAvailableStock() { return availableStock; }
        public void setAvailableStock(Integer availableStock) { this.availableStock = availableStock; }

        public Integer getSaleQuantity() { return saleQuantity; }
        public void setSaleQuantity(Integer saleQuantity) { this.saleQuantity = saleQuantity; }

        public Double getSalePrice() { return salePrice; }
        public void setSalePrice(Double salePrice) { this.salePrice = salePrice; }

        public String getOrderStatus() { return orderStatus; }
        public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

        public LocalDateTime getUpdatedAt() { return updatedAt; }
        public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    }

