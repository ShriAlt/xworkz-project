package com.xworkz.techroute.repository;

import com.xworkz.techroute.entity.ProductMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMasterEntity, Integer> {


    ProductMasterEntity findByProductCode(String productCode);

    List<ProductMasterEntity> findByProductGroupName(String productGroupName);

    boolean existsByProductName(String productName);

    ProductMasterEntity findByCompanyNameAndModel(String companyName, String model);
}
