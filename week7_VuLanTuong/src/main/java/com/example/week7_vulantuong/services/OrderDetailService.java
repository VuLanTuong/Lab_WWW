package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.models.OrderDetail;
import com.example.week7_vulantuong.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    public void insert(OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
    }

}
