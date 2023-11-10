package com.example.week2.services;

import com.example.week2.models.Customer;
import com.example.week2.repositories.CustomerRepository;

import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(){
        customerRepository = new CustomerRepository();
    }

    public Optional<Customer> findAccount(String email, String password){
        return customerRepository.findAccount(email, password);
    }
}
