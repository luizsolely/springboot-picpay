package com.picpay.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.picpay.DTOs.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity threatDuplicateEntity(DataIntegrityViolationException exception) {
		
		ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já está cadastrado.", "400");
		return ResponseEntity.badRequest().body(exceptionDTO);
		
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity threatNotFoundEntity(EntityNotFoundException exception) {
		
		return ResponseEntity.notFound().build();
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity threatGeneralException(Exception exception) {
		
		ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
		return ResponseEntity.internalServerError().body(exceptionDTO);
		
	}
	
}
