package com.example.week2.db;


import com.example.week2.model.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory entityManagerFactory;

    public Connection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("week01_lab_NguyenVanVu_20002865");
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }


}