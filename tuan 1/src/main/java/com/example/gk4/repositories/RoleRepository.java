package com.example.gk4.repositories;

import com.example.gk4.db.Connection;
import com.example.gk4.models.Account;
import com.example.gk4.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RoleRepository {

    private SessionFactory sessionFactory;


    public RoleRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }


    public Role findByName(String name) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Role role = session.createQuery("select r from Role  r where r.name = :name", Role.class)
                    .setParameter("name", name).getSingleResult();
            session.close();
            transaction.commit();
            return role;

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
}



