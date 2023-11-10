package com.example.week2.repositories;

import com.example.week2.controller.ProductPriceMapping;
import com.example.week2.db.Connection;
import com.example.week2.models.ProductPrice;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class ProductPriceRepository {
    private SessionFactory sessionFactory;

    public ProductPriceRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public Optional<ProductPrice> findByProduct(long productId){
        Session session = sessionFactory.openSession();
        TypedQuery<ProductPrice> query = session.createQuery("SELECT productPrice FROM ProductPrice productPrice\n" +
                "                    LEFT JOIN Product product on productPrice.product = product\n" +
                "                    WHERE productPrice.product.product_id = :productId \n" +
                "                    ORDER BY productPrice.price_date_time DESC\n" +
                "                    LIMIT 1 ", ProductPrice.class);
        query.setParameter("productId", productId);

        Optional<ProductPrice> productPrice = Optional.ofNullable(query.getSingleResult());
        session.close();
        return productPrice;
    }

}
