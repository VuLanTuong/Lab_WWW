package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;
import lombok.ToString;
@Table
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;
    private String street;
    private String city;

    @Enumerated(EnumType.STRING)
    private Country country;
    private String number;
    private String zipCode;


    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", number='" + number + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
