package com.example.productEntity.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.example.productEntity.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {

	   @ExceptionHandler
		public ResponseEntity<ErrorStructure<String>> actorNotFoundByIdException(ProductNotFoundException exception){
			ErrorStructure<String > structure = new ErrorStructure<String>();
			structure.setStatuscode(HttpStatus.NOT_FOUND.value());
			structure.setErrorMessage(exception.getMessage());
			structure.setErrorData("Product Object doesn't exist for the given Id");
			return new  ResponseEntity<ErrorStructure<String>>(structure,HttpStatus.NOT_FOUND);
		}
}
