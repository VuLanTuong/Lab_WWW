package com.example.week2.repositories;

import com.example.week2.db.Connection;
import com.example.week2.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductRepository {
    private SessionFactory sessionFactory;

    public ProductRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public List<Product> getAll(){
        Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("select p from Product  p", Product.class).getResultList();
        session.close();
        return products;
    }

    public Product findById(Long id){
        Session session = sessionFactory.openSession();
        Product product = session.createQuery("select p from Product  p where p.id =:id ", Product.class).setParameter("id", id).getSingleResult();
        session.close();
        return product;
    }



}
