package com.example.week7_vulantuong.pks;

import com.example.week7_vulantuong.models.Order;
import com.example.week7_vulantuong.models.Product;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
