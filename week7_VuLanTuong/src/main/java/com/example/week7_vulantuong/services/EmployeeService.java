package com.example.week7_vulantuong.services;

import com.example.week7_vulantuong.enums.EmployeeStatus;
import com.example.week7_vulantuong.models.Employee;
import com.example.week7_vulantuong.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public void save(Employee employee){
        employeeRepository.save(employee);
    }
    public void delete(Employee employee){
       employee.setStatus(EmployeeStatus.IN_ACTIVE);
       employeeRepository.save(employee);
    }
}
