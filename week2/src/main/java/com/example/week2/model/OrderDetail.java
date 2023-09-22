package com.example.week2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @EmbeddedId
    private OrderProductId orderProductId;
    private int quantity;

    @ManyToOne
    private ProductPrice price;
    private String note;

    @ManyToOne
    private Order order;


}
