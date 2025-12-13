package com.xworkz.techroute.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class SalesDTO {

    private String customerName;
    private String productGroupName;
    private String productName;
    private String companyName;
    private String model;
    private String productCode;

    private Integer availableStock;   // readonly in form, but useful for validation
    private Integer saleQuantity;
    private Double salePrice;

    private String orderStatus;       // PENDING / CONFIRMED / CANCELLED / SHIPPED
    private LocalDate orderDate;      // optional: auto-fill when saving

    // Getters and setters
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductGroupName() {
        return productGroupName;
    }
    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }
    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }

    public Integer getSaleQuantity() {
        return saleQuantity;
    }
    public void setSaleQuantity(Integer saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public Double getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}

