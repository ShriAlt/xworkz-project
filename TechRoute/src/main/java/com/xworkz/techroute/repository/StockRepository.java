package com.xworkz.techroute.repository;

import com.xworkz.techroute.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity ,Integer> {

    StockEntity findByProduct_ProductCode(String productCode);
}
