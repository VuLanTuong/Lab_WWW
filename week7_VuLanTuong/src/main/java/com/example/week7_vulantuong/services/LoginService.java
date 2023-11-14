package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.models.Customer;
import com.example.week7_vulantuong.models.Employee;
import com.example.week7_vulantuong.repositories.CustomerRepository;
import com.example.week7_vulantuong.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

}
