package com.example.gk4.repositories;

import com.example.gk4.db.Connection;
import com.example.gk4.models.Account;
import com.example.gk4.models.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LogRepository {
    private SessionFactory sessionFactory;


    public LogRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public void update(Account account){
        System.out.println(account);
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(account);
            transaction.commit();

        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }


    public void remove(Account account){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(account);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public void insert(Log log){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(
                    log);
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
