package com.example.week2.repositories;

import com.example.week2.enums.EmployeeStatus;
import com.example.week2.models.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;


public class EmployeeRepository {

    private EntityManager entityManager;


    public EmployeeRepository(){
        entityManager = Persistence.createEntityManagerFactory("week2").createEntityManager();
    }

    public void insertEmployee(Employee employee){
        entityManager.persist(employee);
    }

    public void setStatus(Employee employee, EmployeeStatus status){
        employee.setStatus(status);

    }

    public void updateEmployee(Employee employee){
        entityManager.merge(employee);

    }
    public Optional<Employee> findById(long id){
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e where  e.id=:id", Employee.class);
        query.setParameter("id", id);
        Employee e = query.getSingleResult();
        return e == null ? Optional.empty() : Optional.of(e);
    }

    public List<Employee> getAllEmployee(){
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }




}
