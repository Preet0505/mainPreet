package com.onerivet.model.dtos;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
	

	private int id;
	
	@NotEmpty
	private String userId;
	
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z0-9.]+@[A-Za-z0-9]+.com$",message="Please enter valid email...")
	private String emailId;
	
	@NotEmpty(message="Please enter a valid First Name")
	@Pattern(regexp="^[^-\\s][a-zA-Z ,'-]+$")
	@Size(min=3,message="First name must be of 3 characters or more")
	@Size(max=100,message="Your First name cannot exceed 100 characters")
	private String firstName;
	
	@NotEmpty(message="Please enter a valid Last Name")
	@Pattern(regexp="^[^-\\s][a-zA-Z ,'-]+$")
	@Size(min=3,message="First name must be of 3 characters or more")
	@Size(max=100,message="Your First name cannot exceed 100 characters")
	private String lastName;
	
	@NotEmpty(message="Please enter a numeric value only")
	@Pattern(regexp="^[6-9][0-9]{9}$",message="10-digit number is required")
//	@Size(min=10,max=10,message = "Must have 10 digit number....")
	private String phoneNumber;
	
	
	private String projectName;
	
	private String profilePictureFileName;
	
	private String profilePictureFilePath;
	
	private  DesignationDto designation;
	
	private ModeOfWorkDto modeOfWork;
	

	
}
