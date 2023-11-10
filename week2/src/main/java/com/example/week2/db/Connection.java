package com.example.week2.db;


import com.example.week2.models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Cache;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connection {
    private static Connection instance = null;
    private SessionFactory sessionFactory;

    private Connection(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductImage.class)
                .addAnnotatedClass(ProductPrice.class)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(CartDetail.class)


                .getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static Connection getInstance(){
        if(instance == null)
            instance = new Connection();
        return instance;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}