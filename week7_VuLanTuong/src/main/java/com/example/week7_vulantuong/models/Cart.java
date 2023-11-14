package com.example.week7_vulantuong.models;

import com.example.week7_vulantuong.pks.CartPK;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "cart")
@Entity @Setter @Getter
public class Cart {

    @Id
    @Column(name = "cust_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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


