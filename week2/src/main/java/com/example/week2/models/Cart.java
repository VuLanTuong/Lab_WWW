package com.example.week2.models;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "cart")
@Entity
public class Cart {
    @Id
    @OneToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CartDetail> details;

    public Cart() {
    }

    public Cart(Customer customer, List<CartDetail> details) {
        this.customer = customer;
        this.details = details;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CartDetail> details) {
        this.details = details;
    }
}
