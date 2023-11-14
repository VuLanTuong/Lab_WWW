package com.example.week7_vulantuong.pks;

import com.example.week7_vulantuong.models.Cart;
import com.example.week7_vulantuong.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CartDetailPK implements Serializable {
    private Cart cart;
    private Product product;
}
