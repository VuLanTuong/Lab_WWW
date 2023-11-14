package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.models.CartDetail;
import com.example.week7_vulantuong.models.Product;
import com.example.week7_vulantuong.repositories.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;

    public void insert(CartDetail cartDetail){

        cartDetailRepository.save(cartDetail);
    }

    public void deleteByProduct(Product product){
        cartDetailRepository.deleteByProduct(product);
    }
}
