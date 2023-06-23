package com.onerivet.service;

import java.util.List;

import com.onerivet.model.dtos.EmployeeDto;
import com.onerivet.model.entity.Employee;

public interface EmployeeService {

	List<EmployeeDto> view();

	EmployeeDto getById(int id);

	String update(int id, EmployeeDto employeeDto);

}
