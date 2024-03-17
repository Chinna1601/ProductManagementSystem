package com.example.productEntity.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class ProductEntity {
@Id

private int productId;
private String productName;
private double productPrice;
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
@Override
public String toString() {
	return "ProductEntity [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
			+ "]";
}

}
