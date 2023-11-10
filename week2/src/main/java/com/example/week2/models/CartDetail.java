package com.example.week2.models;

import jakarta.persistence.*;

@Table(name = "cart_detail")
@Entity
public class CartDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;


    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", referencedColumnName = "cust_id")
    private Cart cart;
    private int quantity;


    public CartDetail() {
    }

    public CartDetail(Product product, Cart cart, int quantity) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "product=" + product +
                ", cart=" + cart +
                ", quantity=" + quantity +
                '}';
    }
}
