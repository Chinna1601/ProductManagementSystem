package com.example.productEntity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productEntity.model.ProductEntity;
import com.example.productEntity.service.ProductService;
import com.example.productEntity.service.impl.ProductServiceImpl;
import com.example.productEntity.utility.ResponseStructure;

@RestController
public class ProductEntityController {
  
  private ProductService service;
   
   public ProductEntityController(ProductServiceImpl service) {
	super();
	this.service = service;
}

@PostMapping("/products/saveProduct")
   public  ResponseEntity<ResponseStructure<ProductEntity>> addProduct(@RequestBody ProductEntity entity){
	   return service.saveProduct(entity);
   }
   
   @GetMapping("/products/getProductById")
   public  ResponseEntity<ResponseStructure<ProductEntity>> getProductById(@RequestParam int productId){
	   return service.getProductById(productId);
   }
   @GetMapping("/products/findAllProducts")
 public  ResponseEntity<ResponseStructure<List<ProductEntity>>> findAllProducts(){
	   return service.findAllProducts();
	      }
   @PutMapping("/products/updateProduct")
 public  ResponseEntity<ResponseStructure<ProductEntity>> updateProduct(@RequestParam int productId,@RequestBody ProductEntity entity){
	   return service.updateProduct(entity,productId);
   }
   @DeleteMapping("/products/deleteProduct")
  public  ResponseEntity<ResponseStructure<String>> deleteProduct(@RequestParam int productId){
	   return service.deleteProduct(productId);
   }
}
