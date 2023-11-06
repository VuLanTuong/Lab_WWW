package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.models.Employee;
import com.example.week7_vulantuong.models.Order;
import com.example.week7_vulantuong.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findByOrderDate(LocalDateTime time){
        return orderRepository.findByOrderDate(time);
    }

    public List<Order> findByEmployeeId(long id){
        return orderRepository.findByEmployee(id);
    }



}
