package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
        select o from Order o where o.orderDate = :orderDate
        """)
    List<Order> findByOrderDate(LocalDateTime orderDate);

    @Query("""
        select o from Order o where o.employee.id = :id
        """)
    List<Order> findByEmployee(Long id);


    List<Order> findByCustomer_Id(long id);

}
