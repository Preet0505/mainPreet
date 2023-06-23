package com.onerivet.deskbook.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.deskbook.models.payload.CityDto;
import com.onerivet.deskbook.models.response.GenericResponse;
import com.onerivet.deskbook.services.CityService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/deskbook")
public class CityController {

	@Autowired
	private CityService cityService;
	
	
	Logger logger = LogManager.getLogger(CityController.class); 

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}



	/**
	 * @purpose: Get all cities
	 * @return: List of cityDto
	 */
	
	
	
	
	@GetMapping("/cities")
	public GenericResponse<List<CityDto>> getCities() {
	    try {
	        GenericResponse<List<CityDto>> genericResponse = new GenericResponse<>(this.cityService.getAllCities(), null);
	        logger.error("Preet is great");
	        System.out.println(10/0);
	        return genericResponse;
	    } catch (Exception e) {
	        logger.error("An error occurred in getCities: {}", e.getMessage());
	        return new GenericResponse<>(null, "An error occurred.");
	    }
	}


}
