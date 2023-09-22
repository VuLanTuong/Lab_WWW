package com.example.week2.services;

import com.example.week2.model.Employee;
import com.example.week2.model.EmployeeStatus;
import com.example.week2.repositories.EmployeeRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private EntityManager entityManager;

    public EmployeeService(){
        entityManager =  Persistence.createEntityManagerFactory("week2")
                .createEntityManager();

        this.employeeRepository = new EmployeeRepository();

    }


//    public EmployeeService(){
//        this.employeeRepository = new EmployeeRepository();
//    }



    public boolean delete(long id){
        Optional<Employee> em = findById(id);
        if(em.isPresent()){
            Employee employee = em.get();
            employee.setStatus(EmployeeStatus.INACTIVE);
            return true;
        }
        return false;
    }

    public boolean active(long id){
        Optional<Employee> em = findById(id);
        if(em.isPresent()){
            Employee employee = em.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public Optional<Employee> findById(long id){
      return employeeRepository.findById(id);
    }


    public List<Employee> getAllEmp(){
        return employeeRepository.getAllEmployee();

    }


}
