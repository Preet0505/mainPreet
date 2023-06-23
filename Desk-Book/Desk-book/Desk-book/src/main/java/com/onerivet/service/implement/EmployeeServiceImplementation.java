package com.onerivet.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.model.dtos.EmployeeDto;
import com.onerivet.model.entity.Employee;
import com.onerivet.repository.EmployeeRepository;
import com.onerivet.service.EmployeeService;
@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<EmployeeDto> view() {
		List<EmployeeDto> employee = employeeRepository.findAll().stream().map((x)->employeeToEmployeeDto(x)).collect(Collectors.toList());
		
		return employee;
	}

	@Override
	public EmployeeDto getById(int id) {
		
		return employeeToEmployeeDto(employeeRepository.findById(id).get());
	}
	
	
	@Override
	public String update(int id, EmployeeDto employeeDto) {
		
		Employee e = employeeRepository.findById(id).get();
//		if(e==null)
//			return "Enter Valid id....";
//		else
//			e.setUserId(employee.getUserId());
//			e.setEmailId(employee.getEmailId());
//			e.setFirstName(employee.getFirstName());
//			e.setLastName(employee.getLastName());
//			e.setPhoneNumber(employee.getPhoneNumber());
//			e.setProject(employee.getProject());
//			e.setProfilePictureFileName(employee.getProfilePictureFileName());
//			e.setProfilePictureFilePath(employee.getProfilePictureFilePath());
//			e.setDesignation(employee.getDesignation());
//			e.setModeOfWork(employee.getModeOfWork());
//			e.setRole(employee.getRole());
//			e.setWorkingDay(employee.getWorkingDay());

			employeeDto.setId(e.getId());
			employeeRepository.save(employeeDtoTOEmployee(employeeDto));
			return "added successfully......";
	}
	
	
	
	
	private Employee employeeDtoTOEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		return employee;
	}
	
	private EmployeeDto employeeToEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}


	
	
	

}
