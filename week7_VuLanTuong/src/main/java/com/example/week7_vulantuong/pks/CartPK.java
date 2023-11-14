package com.example.week7_vulantuong.pks;

import com.example.week7_vulantuong.models.Customer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CartPK implements Serializable {
    private Customer customer;
}
