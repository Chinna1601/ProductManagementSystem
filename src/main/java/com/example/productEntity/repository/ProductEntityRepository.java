package com.example.productEntity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productEntity.model.ProductEntity;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {
@Query(value="select * from product_entity",nativeQuery=true)
	List<ProductEntity> findAllproducts();

}
