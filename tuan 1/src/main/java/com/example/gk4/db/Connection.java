package com.example.gk4.db;

import com.example.gk4.models.Account;
import com.example.gk4.models.GrantAccess;
import com.example.gk4.models.Log;
import com.example.gk4.models.Role;
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
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(GrantAccess.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Log.class)
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
