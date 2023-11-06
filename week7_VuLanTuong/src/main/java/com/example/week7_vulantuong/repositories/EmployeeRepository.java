package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
