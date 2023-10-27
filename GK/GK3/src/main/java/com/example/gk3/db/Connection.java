package com.example.gk3.db;

import com.example.gk3.models.Candidate;
import com.example.gk3.models.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connection {
    private static Connection instance = null;
    private SessionFactory sessionFactory = null;
    private Connection(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Experience.class)
                .addAnnotatedClass(Candidate.class)
                .getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    public static Connection getInstance(){
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}

