package com.onerivet.deskbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.deskbook.models.payload.CityDto;
import com.onerivet.deskbook.models.response.GenericResponse;
import com.onerivet.deskbook.repository.CityRepo;
import com.onerivet.deskbook.services.CityService;
import com.onerivet.deskbook.services.EmailService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.mail.MessagingException;

@RestController
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/deskbook")
public class CityController {

	@Autowired
	private CityService cityService;
	
//	@Autowired
//	private CityRepo cityRepo;
	
	
	

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}



	/**
	 * @purpose: Get all cities
	 * @return: List of cityDto
	 * @throws MessagingException 
	 */
	@GetMapping("/cities")
	public GenericResponse<List<CityDto>> getCities() throws MessagingException {
		GenericResponse<List<CityDto>> genericResponse = new GenericResponse<>(this.cityService.getAllCities(), null);
		return genericResponse;
	}
}
