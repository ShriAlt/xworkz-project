package com.xworkz.techRoute.dto;

import com.xworkz.techRoute.enums.CustomerType;
import com.xworkz.techRoute.enums.PaymentMode;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {
    public CustomerDto(){
        System.out.println("no args of CustomerDto");
    }

    private int id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotNull(message = "Customer type must be specified")
    private CustomerType customerType;

//    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

//    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Indian contact number")
    private String contact;

//    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$", message = "Invalid GST number")
    private String gst;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "City is required")
    private String city;

//    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid Indian pin code")
    private String pinCode;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Billing address is required")
    private String billingAddress;

    @NotBlank(message = "Shipping address is required")
    private String shippingAddress;

    @NotNull(message = "Payment mode must be specified")
    private PaymentMode paymentMode;

}
