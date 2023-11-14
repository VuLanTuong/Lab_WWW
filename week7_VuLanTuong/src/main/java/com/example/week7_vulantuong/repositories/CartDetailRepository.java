package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.CartDetail;
import com.example.week7_vulantuong.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

    @Transactional
    void deleteByProduct(Product product);
}
