package com.example.productEntity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.productEntity.exception.ProductNotFoundException;
import com.example.productEntity.model.ProductEntity;
import com.example.productEntity.repository.ProductEntityRepository;
import com.example.productEntity.service.ProductService;
import com.example.productEntity.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService{

private ResponseStructure<ProductEntity> structure;
	private ProductEntityRepository productRepository;
	private ResponseStructure<List<ProductEntity>> liststructure ;
	private ResponseStructure<String>  stringstucture;

	public ProductServiceImpl(ResponseStructure<ProductEntity> structure, ProductEntityRepository productRepository,
			ResponseStructure<List<ProductEntity>> liststructure, ResponseStructure<String> stringstucture) {
		super();
		this.structure = structure;
		this.productRepository = productRepository;
		this.liststructure = liststructure;
		this.stringstucture = stringstucture;
	}


	@Override
	public ResponseEntity<ResponseStructure<ProductEntity>> saveProduct(ProductEntity entity) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value()).setMessage("Product Saved sucessFully").setData(productRepository.save(entity)));
	}

	@Override
	public ResponseEntity<ResponseStructure<ProductEntity>> getProductById(int productId) {
		// TODO Auto-generated method stub
		
		return productRepository.findById(productId).map(product -> ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value()).setMessage("Data Found").setData(product))).orElseThrow(() -> new ProductNotFoundException("Product Not Found")) ;
	}



	@Override
	public ResponseEntity<ResponseStructure<ProductEntity>> updateProduct(ProductEntity entity, int productId) {
		// TODO Auto-generated method stub
//		return productRepository.findById(productId).map(entity -> ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value()).setMessage("Data Found").setData(entity))).orElseThrow(() -> new ProductNotFoundException("Product Not Found")) ;
//  return productRepository.findById(productId).map( product ->  ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value()).setMessage("Data Found").setData(product.setProductName(entity.getProductName()).setProductPrice(entity.getProductPrice()))).orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
//return null;
		return  productRepository.findById(productId).map(exproduct -> {
			entity.setProductId(exproduct.getProductId());
			exproduct=productRepository.save(exproduct);
			return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value()).setMessage("Data Updated").setData(exproduct));
		}).orElseThrow(()->new ProductNotFoundException("Product Not Found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResponseEntity<ResponseStructure<List<ProductEntity>>> findAllProducts() {
		// TODO Auto-generated method stub
		/**
		 * 
		
		return ResponseEntity.ok(liststructure.setStatusCode(HttpStatus.OK.value()).setMessage("Products Data").setData(productRepository.findAllproducts()));
	 */
		List<ProductEntity> products= productRepository.findAll();
		if(!products.isEmpty()) {
			return ResponseEntity.ok(liststructure.setData(products).setStatusCode(HttpStatus.OK.value()).setMessage("Product List"));
		}
		else {
			throw new RuntimeException();
		}
	}

//	@Override
//	public ResponseEntity<ResponseStructure<ProductEntity>> saveProduct(ProductEntity entity) {
//		// TODO Auto-generated method stub
//		ResponseStructure<ProductEntity> response = new ResponseStructure<ProductEntity>();
//		response.setStatusCode(HttpStatus.CREATED.value());
//		response.setMessage("Product Inserted SucessFully");
//		response.setData(productRepository.save(entity));
//		
//		return new ResponseEntity<ResponseStructure<ProductEntity>>(response,HttpStatus.CREATED) ;
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public ResponseEntity<ResponseStructure<ProductEntity>> getProductById(int productId) {
//		// TODO Auto-generated method stub
//		ResponseStructure<ProductEntity> response = new ResponseStructure<ProductEntity>();
//		response.setStatusCode(HttpStatus.FOUND.value());
//		response.setMessage("Product fETCHED SucessFully");
//		Optional<ProductEntity> optional=productRepository.findById(productId);
//		response.setData(optional.get());
//		return new ResponseEntity<ResponseStructure<ProductEntity>>(response,HttpStatus.FOUND);
//	}
//
//	@Override
//	public ResponseEntity<ResponseStructure<List<ProductEntity>>> findAllProducts() {
//		// TODO Auto-generated method stub
//		ResponseStructure<List<ProductEntity>> response = new ResponseStructure<List<ProductEntity>>();
//		response.setStatusCode(HttpStatus.FOUND.value());
//		response.setMessage("Product fETCHED SucessFully");
//		response.setData(productRepository.findAllproducts());
//		return new ResponseEntity<ResponseStructure<List<ProductEntity>>>(response,HttpStatus.FOUND);
//	}
//
//	@Override
//	public ResponseEntity<ResponseStructure<ProductEntity>> updateProduct(ProductEntity entity,int productId) {
//		// TODO Auto-generated method stub
//		
//		Optional<ProductEntity>  optional= productRepository.findById(productId);
//		ProductEntity productEntity= optional.get();
//		if(productEntity!=null) {
//			productEntity.setProductName(entity.getProductName());
//			productEntity.setProductPrice(entity.getProductPrice());
//			ResponseStructure<ProductEntity> response = new ResponseStructure<ProductEntity>();
//		response.setStatusCode(HttpStatus.OK.value());
//		response.setMessage("Data Modified SucessFully");
//		response.setData(productRepository.save(productEntity));
//		return new ResponseEntity<ResponseStructure<ProductEntity>>(response,HttpStatus.OK);
//		}
//		else {
//			throw new ProductNotFoundException("Id Not Found");
//		}
//	}
//
//	
//	@Override
//	public ResponseEntity<ResponseStructure<String>> deleteProduct(int productId) {
//
//		// TODO Auto-generated method stub
//	
//		Optional<ProductEntity> optional = productRepository.findById(productId);
//		if(optional.isPresent()) {
//			
//			productRepository.delete(optional.get());
//		ResponseStructure<String> response = new ResponseStructure<String>();
//		response.setStatusCode(HttpStatus.OK.value());
//		response.setMessage("Product DELETED SucessFully");		
//		response.setData("Product Deleted SucessFully");
//		
//		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK) ;
//		}
//		else {
//			throw new ProductNotFoundException("Id Not Found");
//		}
//	}
	
}
