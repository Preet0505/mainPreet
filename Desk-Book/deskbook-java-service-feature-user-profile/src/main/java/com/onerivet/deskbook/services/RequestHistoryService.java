package com.onerivet.deskbook.services;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.onerivet.deskbook.models.payload.EmployeeDto;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;

public interface RequestHistoryService {

		
	public List<RequestHistoryDto> getRequestHistory(String id , Pageable pageable, Integer status);

	public List<RequestHistoryDto> searchByFirstNameOrLastName(String name, Pageable pageable);
	
	
}
