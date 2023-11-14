package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.models.Cart;
import com.example.week7_vulantuong.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;


    public Cart findByCustomerId(long id){
        return cartRepository.findByCustomer_Id(id);
    }

}
