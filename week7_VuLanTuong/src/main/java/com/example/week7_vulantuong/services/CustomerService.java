package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.models.Customer;
import com.example.week7_vulantuong.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public Customer findByEmailAndPassword(String email, String password){
        return customerRepository.findByEmailAndPassword(email, password);
    }
}
