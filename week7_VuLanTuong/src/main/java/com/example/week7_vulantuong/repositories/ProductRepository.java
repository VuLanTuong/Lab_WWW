package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.Product;
import com.example.week7_vulantuong.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
