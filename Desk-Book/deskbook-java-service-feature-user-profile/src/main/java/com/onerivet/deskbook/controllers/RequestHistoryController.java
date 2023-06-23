package com.onerivet.deskbook.controllers;

import java.security.Principal;
import java.util.List;

import org.modelmapper.internal.bytebuddy.description.type.TypeDescription.Generic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.deskbook.models.payload.EmployeeDto;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.models.response.GenericResponse;
import com.onerivet.deskbook.services.RequestHistoryService;
import com.onerivet.deskbook.util.PaginationAndSorting;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@Validated
@SecurityRequirement(name="bearerAuth")
@RequestMapping("/api/deskbook")
public class RequestHistoryController {

	
	@Autowired
	private RequestHistoryService requestHistoryService;
	
	
	public RequestHistoryController(RequestHistoryService requestHistoryService) {
		super();
		this.requestHistoryService=requestHistoryService;
	}
	
	
	/**
	 * 
	 * @purpose:Get all details by request-history and {status}
	 * @param: principal , pagination , status
	 * @return: RequestHistoryDto
	 */
	
	@GetMapping(value = {"/request-history/{status}","/request-history"})
	public GenericResponse<List<RequestHistoryDto>> getRequestHistory(Principal principal , PaginationAndSorting pagination ,@PathVariable(required=false) Integer status){
		GenericResponse<List<RequestHistoryDto>> genericResponse = new GenericResponse<>(this.requestHistoryService.getRequestHistory(principal.getName(),pagination.createPageRequest(),status), null);
//		System.out.println(genericResponse);
		return genericResponse;
		
	}
	

	/**
	 * 
	 * @purpose: Get name by Search
	 * @param: name , paginationAndSorting
	 * @return: RequestHistoryDto
	 */
	
	
	@GetMapping("/search/{name}")
	public GenericResponse<List<RequestHistoryDto>> getRequestHistory(@PathVariable("name") String name,PaginationAndSorting paginationAndSorting){
		GenericResponse<List<RequestHistoryDto>> genericResponse = new GenericResponse<>(this.requestHistoryService.searchByFirstNameOrLastName(name, paginationAndSorting.createPageRequest()),null);
		return genericResponse;
		
	}
	
	
}
