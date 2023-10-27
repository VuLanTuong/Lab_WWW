package com.fit.se.ontap2410.backend.repositories;

import com.fit.se.ontap2410.backend.models.Staff;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class StaffRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public StaffRepository() {
        entityManager = ConnectDB.getInstance().getEmf().createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insert(Staff staff){
        try {
            transaction.begin();
            entityManager.persist(staff);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    public void update(Staff staff){
        try {
            transaction.begin();
            entityManager.merge(staff);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    public List<Staff> getAll(){
        return entityManager.createNamedQuery("Staff.findAll",Staff.class)
                .getResultList();
    }

    public Optional<Staff> getById(long id){
        Staff rs = entityManager.find(Staff.class, id);
        return rs == null ? Optional.empty() : Optional.of(rs);
    }
//    why

}
