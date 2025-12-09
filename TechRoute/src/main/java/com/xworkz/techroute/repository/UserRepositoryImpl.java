package com.xworkz.techroute.repository;

import com.xworkz.techroute.entity.CustomerEntity;
import com.xworkz.techroute.entity.ProductGroupEntity;
import com.xworkz.techroute.entity.ProductMasterEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final EntityManagerFactory entityManagerFactory;

    public UserRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<ProductGroupEntity> findAllProductGroupName() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query=  entityManager.createNamedQuery("findAllProductGroupName");
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

//    @Override
//    public List fetchAllProducts() {
//        EntityManager entityManager = null;
//        try {
//            entityManager = entityManagerFactory.createEntityManager();
//            Query query=  entityManager.createNamedQuery("findAllProducts");
//            return  query.getResultList();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//        finally {
//            if (entityManager != null && entityManager.isOpen()) {
//                entityManager.close();
//            }
//        }
//    }

//    @Override
//    public List<CustomerEntity> findAllCreditors() {
//        EntityManager entityManager = null;
//        try {
//            entityManager = entityManagerFactory.createEntityManager();
//            Query query=  entityManager.createNamedQuery("findAllCreditors");
//            return  query.getResultList();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//        finally {
//            if (entityManager != null && entityManager.isOpen()) {
//                entityManager.close();
//            }
//        }
//    }

    @Override
    public List<CustomerEntity> findAllCustomer() {
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
    public CustomerEntity findByCustomerName(String name) {

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query=  entityManager.createNamedQuery("findByCustomerName");
            query.setParameter("customerName",name);
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
    public List<ProductMasterEntity> fetchAllProductsByGroupName(String groupName) {
        System.out.println("++++++++++++++++++++++++++++++++ in repo");
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("fetchAllProductByGroupName");
            query.setParameter("groupName", groupName);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}

