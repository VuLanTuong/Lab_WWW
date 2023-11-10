package com.example.week2.repositories;

import com.example.week2.db.Connection;
import com.example.week2.models.Cart;
import com.example.week2.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrderRepository {
    private SessionFactory sessionFactory;

    public OrderRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public void insert(Order order){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(order);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

}
