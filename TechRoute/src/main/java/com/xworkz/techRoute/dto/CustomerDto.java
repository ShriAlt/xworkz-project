package com.xworkz.techRoute.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {
    public CustomerDto(){
        System.out.println("no args of CustomerDto");
    }

    private String customerName;
    private String customerType;
    private String email;
    private String contact;
    private String gst;
    private String country;
    private String state;
    private String city;
    private String pincode;
    private String address;
    private String billingAddress;
    private String shippingAddress;

}
