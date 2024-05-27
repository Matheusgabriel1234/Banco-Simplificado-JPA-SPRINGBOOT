package com.example.TestePicpay.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.TestePicpay.dto.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity throwDuplicateEntry(DataIntegrityViolationException err) {
		ExceptionDTO exceptiondto = new ExceptionDTO("Usuario Já Cadastrado","400");
		return ResponseEntity.badRequest().body(exceptiondto);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity Entity(DataIntegrityViolationException err) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threatGeneralException(DataIntegrityViolationException err) {
		ExceptionDTO exceptiondto = new ExceptionDTO(err.getMessage(),"500");
		
		return ResponseEntity.internalServerError().body(exceptiondto);
	}
 
}
