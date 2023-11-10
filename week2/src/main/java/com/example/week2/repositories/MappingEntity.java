package com.example.week2.repositories;

import com.example.week2.db.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;

public class MappingEntity {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Connection.getInstance().getSessionFactory();
    }
}
