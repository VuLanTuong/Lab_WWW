package com.example.gk3.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.checkerframework.checker.units.qual.C;

public class Connection {
    private final EntityManager entityManager;
    private static Connection connection;


    public Connection() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gk3");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();

        }
        return connection;
    }


}

