package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.Cart;
import com.example.week7_vulantuong.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByCustomer_Id(long id);


}
