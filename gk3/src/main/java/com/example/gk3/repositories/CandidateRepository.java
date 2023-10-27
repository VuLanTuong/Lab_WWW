package com.example.gk3.repositories;

import com.example.gk3.db.Connection;
import com.example.gk3.models.Candidate;
import com.example.gk3.models.Experience;
import com.example.gk3.models.Roles;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CandidateRepository {
    private SessionFactory sessionFactory;

    public CandidateRepository() {
        this.sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public void insertCan(Candidate candidate){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(candidate);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    public List<Candidate> findAll(){
        Transaction transaction = null;

        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Candidate> candidateList = session.createQuery("select c from Candidate c", Candidate.class).getResultList();
            transaction.commit();
            return  candidateList;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }


    public Candidate findById(long id){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Candidate candidate = new Candidate();
                   Query query = session.createQuery("select c from Candidate c where c.id =:id", Candidate.class);
                   query.setParameter("id", id);
                   candidate = (Candidate) query.getSingleResult();
            transaction.commit();
            return candidate;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }

    public List<Candidate> findByRole(Roles roles){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Candidate> candidates = new ArrayList<>();
            Query query = session.createQuery("select c from Candidate c join Experience  e " +
                    "on e.candidate = c " +
                    "where e.role =: role", Candidate.class);
            query.setParameter("role", roles);
            candidates = (List<Candidate>) query.getResultList();
            transaction.commit();
            return candidates;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }

    public List<Candidate> findByEmail(){
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Candidate> candidateList = session.createQuery("select c from Candidate c where c.email != \"\" ", Candidate.class).getResultList();
        transaction.commit();
        return candidateList;
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public List<Candidate> findByDate(LocalDate date){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Candidate c " +
                        " left join Experience e on e.candidate = c " +
                        " where e.toDate  =: date",
                Candidate.class);
        query.setParameter("date", date);
        List<Candidate> candidateList = query.getResultList();
        session.close();
        return candidateList;
    }

//    public static void main(String[] args) {
//        CandidateRepository candidateRepository = new CandidateRepository();
//        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        final LocalDate dt = LocalDate.parse("2023-10-26",dtf);
//
//        System.out.println(candidateRepository.findByDate(dt));
//
//    }


}
