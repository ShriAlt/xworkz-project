package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.entity.PurchaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public List findAllCustomer() {
        EntityManager entityManager = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query=  entityManager.createNamedQuery("findAllCustomer");
            return  query.getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public CustomerEntity fetchCustomerEntity(int id) {
        EntityManager entityManager = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query=  entityManager.createNamedQuery("findById");
            query.setParameter("id",id);
            return (CustomerEntity) query.getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query=  entityManager.createNamedQuery("deleteById");
            query.setParameter("id", id);
            query.executeUpdate();
            entityTransaction.commit();
            return true;
        }
        catch (Exception e){
            if (entityTransaction != null && entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    @Override
    public CustomerEntity fetchCustomerEntityByMail(String email) {
        EntityManager entityManager = null;
        CustomerEntity customerEntity;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findByCustomerMail");
            query.setParameter("email",email);
            customerEntity =  (CustomerEntity) query.getSingleResult();
            return customerEntity;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    @Override
    public CustomerEntity fetchCustomerEntityByNumber(String number) {
        EntityManager entityManager = null;
        CustomerEntity customerEntity;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findByCustomerPhone");
            query.setParameter("contact",number);
            customerEntity =  (CustomerEntity) query.getSingleResult();
            return customerEntity;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<PurchaseEntity> findAllOrders() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findAllOrders");
            return query.getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public PurchaseEntity findOrderById(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findOrderById");
            query.setParameter("id",id);
            return (PurchaseEntity) query.getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }    }
}
