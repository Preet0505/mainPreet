package com.crud.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onerivet.entity.Response1;
import com.onerivet.exception.ResourceNotFound;

@SuppressWarnings("serial")
@RestControllerAdvice
public class GlobalException extends RuntimeException {
	
	@ExceptionHandler(ResourceNotFound.class)
	public Response1 resourceNotFound(ResourceNotFound exc) {
		
		String message = exc.getMessage();
		LocalDateTime now = LocalDateTime.now();
		Response1 res = new Response1(message,now);
		return res;
	}
	
	
	
}
