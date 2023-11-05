package com.example.week7_vulantuong.repositories;

import com.example.week7_vulantuong.models.Product;
import com.example.week7_vulantuong.models.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
//    List<ProductPrice> findByProduct_Product_idOrderByPrice_date_timeDesc(Product product);

    @Query(
                    """
                    SELECT productPrice FROM ProductPrice productPrice
                    LEFT JOIN Product product on productPrice.product = product
                    WHERE productPrice.product.product_id = :productId
                    ORDER BY productPrice.price_date_time DESC
                    LIMIT 1
                    """
    )
    Optional<ProductPrice> findProductPriceByProductId(long productId);
}
