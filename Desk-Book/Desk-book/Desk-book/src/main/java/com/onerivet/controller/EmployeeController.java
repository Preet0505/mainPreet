package com.onerivet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.model.dtos.EmployeeDto;
import com.onerivet.model.entity.Employee;
import com.onerivet.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
//	@PostMapping("/add-employee")
	
	@GetMapping("/get-all-employee")
	public List<EmployeeDto> getAllUser(){
		return employeeService.view();
	}
	
	
	@GetMapping("/{id}")
	public EmployeeDto getbyId(@PathVariable int id) {
		return employeeService.getById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateById(@PathVariable int id,@RequestBody @Valid EmployeeDto employee) {
		return employeeService.update(id,employee);
	}
	
	
}
