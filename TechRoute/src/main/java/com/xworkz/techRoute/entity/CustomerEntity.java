package com.xworkz.techRoute.entity;

import com.xworkz.techRoute.enums.CustomerType;
import com.xworkz.techRoute.enums.PaymentMode;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_details")
@NamedQuery(
        name = "findByCustomerMail",
        query = "SELECT u FROM CustomerEntity u WHERE u.email = :email" )
@NamedQuery(
        name = "findByCustomerPhone",
        query = "SELECT u FROM CustomerEntity u WHERE u.contact = :contact" )
@NamedQuery(
        name = "findAllCustomer",
        query = " SELECT entity from CustomerEntity entity "
)
@NamedQuery(
        name = "findById",
        query = " SELECT entity from CustomerEntity entity where entity.id = :id"
)
@NamedQuery(
        name = "deleteById",
        query = " delete  CustomerEntity where id = :id"
)

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_type")
    @Enumerated(value = EnumType.STRING)
    private CustomerType customerType;

    private String email;

    private String contact;

    private String gst;

    private String country;

    private String state;

    private String city;

    @Column(name = "pin_code")
    private String pinCode;

    private String address;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "payment_mode")
    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;

}
