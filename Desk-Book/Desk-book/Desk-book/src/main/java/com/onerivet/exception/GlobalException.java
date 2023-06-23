package com.onerivet.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onerivet.model.entity.Response_Api;

@SuppressWarnings("serial")
@RestControllerAdvice
public class GlobalException extends RuntimeException{
	
	@ExceptionHandler(ResourceNotFound.class)
	public Response_Api resourceNotFoundHandler(ResourceNotFound ex) {
		
		String message = ex.getMessage();
		LocalDateTime now = LocalDateTime.now();
		Response_Api responseapi = new Response_Api(message,now);
		
		return responseapi;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> method(MethodArgumentNotValidException excp){
			Map<String,String> response = new HashMap<>();
		excp.getBindingResult().getAllErrors().forEach(error ->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
		});
		
		return response;
	}

}
