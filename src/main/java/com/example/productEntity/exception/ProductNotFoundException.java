package com.example.productEntity.exception;

public class ProductNotFoundException extends RuntimeException {
private String message;
public ProductNotFoundException(String message) {
	this.message=message;
}
public String getMessage() {
	return message;
}
}
