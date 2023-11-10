package com.example.week2.pks;


import com.example.week2.models.Order;
import com.example.week2.models.Product;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
