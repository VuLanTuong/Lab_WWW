package com.example.week2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custonmerId;
    private String customerName;
    private String email;
    private String phone;
    private String address;

    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;

    public Customer(String customerName, String email, String phone, String address, ProductStatus status) {
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Customer() {

    }
}
