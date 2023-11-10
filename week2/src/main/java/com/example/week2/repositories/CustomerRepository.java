package com.example.week2.repositories;

import com.example.week2.db.Connection;
import com.example.week2.models.Customer;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class CustomerRepository {

    private SessionFactory sessionFactory;

    public CustomerRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }


    public Optional<Customer> findAccount(String email, String password) {
        Session session = sessionFactory.openSession();
        TypedQuery<Customer> query = session.createQuery("SELECT c FROM Customer c WHERE  c.email = :email and c.password  = :password ", Customer.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }
}

