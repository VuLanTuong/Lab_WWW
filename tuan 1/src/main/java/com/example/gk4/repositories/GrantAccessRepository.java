package com.example.gk4.repositories;

import com.example.gk4.db.Connection;
import com.example.gk4.models.Account;
import com.example.gk4.models.GrantAccess;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GrantAccessRepository {
    private SessionFactory sessionFactory;


    public GrantAccessRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }


    public GrantAccess findById(String id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT g FROM GrantAccess g JOIN Account a on g.account = a WHERE a.id = :id", GrantAccess.class);
        query.setParameter("id", id);
        GrantAccess grantAccess = (GrantAccess) query.getSingleResult();
        System.out.println(grantAccess);
        session.close();
        return grantAccess;
    }
    public void update(GrantAccess grantAccess){

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(grantAccess);
            transaction.commit();

        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }


    public void remove(GrantAccess grantAccess){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(grantAccess);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public void insert(GrantAccess grantAccess){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(
                    grantAccess);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public static void main(String[] args) {
        GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
        System.out.println(grantAccessRepository.findById("1"));
    }

}
