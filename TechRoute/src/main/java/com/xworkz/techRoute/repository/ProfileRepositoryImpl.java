package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.CustomerEntity;
import com.xworkz.techRoute.entity.RegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    public ProfileRepositoryImpl(){
        System.out.println("no args of ProfileRepositoryImpl");
    }
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public <S> boolean save(S entity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            System.err.println(entity);
            entityManager.persist(entity);
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
    public RegisterEntity checkByMail(String email) {
        EntityManager entityManager = null;
        RegisterEntity registerEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findByMail");
            query.setParameter("email",email);
           registerEntity =  (RegisterEntity) query.getSingleResult();
            return registerEntity;
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
    public RegisterEntity checkByPhone(String phone) {

        EntityManager entityManager = null;
        RegisterEntity registerEntity;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findByPhone");
            query.setParameter("phoneNumber",phone);
            registerEntity =  (RegisterEntity) query.getSingleResult();
            return registerEntity;
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

//    @Override
//    public <T> boolean saveLoginInfo(T entity) {
//        EntityManager entityManager = null;
//        EntityTransaction entityTransaction = null;
//        try {
//            entityManager = entityManagerFactory.createEntityManager();
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//            entityManager.persist(entity);
//            entityTransaction.commit();
//            return true;
//        }
//        catch (Exception e){
//            if (entityTransaction != null && entityTransaction.isActive()){
//                entityTransaction.rollback();
//            }
//            e.printStackTrace();
//            return false;
//        }
//        finally {
//            if (entityManager != null && entityManager.isOpen()) {
//                entityManager.close();
//            }
//        }
//    }

    @Override
    public <T> boolean updateProfile(T entity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(entity);
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
    public boolean clearOtp() {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query=  entityManager.createNamedQuery("clearExpiredOtp");
            query.setParameter("currentTime", LocalDateTime.now());
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
    public List findAll() {
        EntityManager entityManager = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query=  entityManager.createNamedQuery("findAll");
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
}
