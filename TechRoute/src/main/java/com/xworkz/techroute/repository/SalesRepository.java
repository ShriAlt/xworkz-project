package com.xworkz.techroute.repository;

import com.xworkz.techroute.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity,Long> {

}
