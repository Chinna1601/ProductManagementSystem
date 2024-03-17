package com.example.productEntity.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productEntity.model.ProductEntity;
import com.example.productEntity.utility.ResponseStructure;

public interface ProductService {
	ResponseEntity<ResponseStructure<ProductEntity>> saveProduct(ProductEntity entity);
	ResponseEntity<ResponseStructure<ProductEntity>> getProductById( int productId);
	ResponseEntity<ResponseStructure<List<ProductEntity>>> findAllProducts();
	ResponseEntity<ResponseStructure<ProductEntity>> updateProduct( ProductEntity entity, int productId);
	ResponseEntity<ResponseStructure<String>> deleteProduct( int productId);
}
