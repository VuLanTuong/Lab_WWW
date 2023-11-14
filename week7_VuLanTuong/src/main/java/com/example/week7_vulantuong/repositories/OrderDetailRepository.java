package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
