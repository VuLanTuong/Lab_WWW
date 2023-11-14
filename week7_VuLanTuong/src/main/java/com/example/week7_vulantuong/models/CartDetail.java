package com.example.week7_vulantuong.models;

import com.example.week7_vulantuong.pks.CartDetailPK;
import jakarta.persistence.*;

@Table(name = "cart_detail")
@Entity
@IdClass(CartDetailPK.class)
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

    @OneToOne
    private ProductPrice price;


    public CartDetail() {
    }

    public CartDetail(Product product, Cart cart, int quantity, ProductPrice price) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.price = price;
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


    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
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
