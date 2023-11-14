package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmailAndPassword(String email, String password);

    Employee findById(long id);
}
