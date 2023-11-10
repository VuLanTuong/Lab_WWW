package com.example.week2.repositories;

import com.example.week2.db.Connection;
import com.example.week2.models.CartDetail;
import com.example.week2.models.Customer;
import com.example.week2.models.Order;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CartDetailRepository {

    private SessionFactory sessionFactory;

    public CartDetailRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public void insert(CartDetail cartDetail){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(
                    cartDetail);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public List<CartDetail> findByCartId(long id){
        Session session = sessionFactory.openSession();
        TypedQuery<CartDetail> query = session.createQuery("SELECT c FROM CartDetail c WHERE  c.cart.id = :id ", CartDetail.class);
        query.setParameter("id", id);
        List<CartDetail> details = query.getResultList();
        session.close();
        return details;
    }
}
