package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;

@Table
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;
    private String street;
    private String city;

    @Embedded
    private Country country;
    private String number;
    private String zipCode;


    public Address() {
    }
}
