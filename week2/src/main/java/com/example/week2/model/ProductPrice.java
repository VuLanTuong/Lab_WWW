package com.example.week2.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class ProductPrice {

    private Date price_date_time;

    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private long price;
    private String note;



    public ProductPrice(){

    }

    public ProductPrice(Date price_date_time, long price, String note) {
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPrice)) return false;
        ProductPrice that = (ProductPrice) o;
        return price == that.price && Objects.equals(price_date_time, that.price_date_time) && Objects.equals(product, that.product) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price_date_time, product, price, note);
    }
}
