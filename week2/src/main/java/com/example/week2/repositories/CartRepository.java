package com.example.week2.repositories;

import com.example.week2.db.Connection;
import com.example.week2.models.Cart;
import com.example.week2.models.Customer;
import com.example.week2.models.Order;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class CartRepository {
    private SessionFactory sessionFactory;

    public CartRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public void insert(Cart cart){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(
                    cart);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public Cart findById(long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
           Cart cart = session.find(Cart.class, id);
            transaction.commit();
            return cart;
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return null;
    }


}
