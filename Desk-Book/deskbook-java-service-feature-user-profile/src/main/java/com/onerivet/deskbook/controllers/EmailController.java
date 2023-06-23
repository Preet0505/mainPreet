package com.onerivet.deskbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.deskbook.services.impl.EmailServiceImpl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.mail.MessagingException;


@RestController
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/deskbook")
public class EmailController {

	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	
	@GetMapping("/email")
	public String getCities() throws MessagingException {
		
		return emailServiceImpl.sendMailRequest("jitendra.singh@1rivet.com", "Hello pratik", "check api ");
	}
}
