package com.xworkz.techRoute.repository;

import com.xworkz.techRoute.entity.LoginEntity;
import com.xworkz.techRoute.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class UserRepositoryImpl implements UserRepository {

    public UserRepositoryImpl(){
        System.out.println("no args of UserRepositoryImpl");
    }
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveUser(UserEntity userEntity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(userEntity);
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
    public UserEntity checkByMail(String email) {
        EntityManager entityManager = null;
        UserEntity userEntity = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findByMail");
            query.setParameter("email",email);
           userEntity =  (UserEntity) query.getSingleResult();
            return userEntity;
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
    public UserEntity checkByPhone(String phone) {

        EntityManager entityManager = null;
        UserEntity userEntity ;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("findByPhone");
            query.setParameter("phoneNumber",phone);
            userEntity =  (UserEntity) query.getSingleResult();
            return userEntity;
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
    public boolean saveLoginInfo(LoginEntity loginEntity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(loginEntity);
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
