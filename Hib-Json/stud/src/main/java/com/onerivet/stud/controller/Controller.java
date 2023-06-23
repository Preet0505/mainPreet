package com.onerivet.stud.controller;

import java.util.Iterator;
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.stud.student.Student;

@RestController
//
@RequestMapping("/users")
public class Controller {
	
	static List<Student> student = new LinkedList<Student>();
	
	@GetMapping("/welcome")
	public String Display() {
		return "Success web";
		
	}
	
	@GetMapping("/add")
	public String getall() {
		
		student.add(new Student (01,"Preet Patel","preetpatel5543"));
		student.add(new Student (02,"Deep Patel","deeppatel5544"));
		student.add(new Student (03,"Jaki Patel","jakipatel5544"));
		return "Successfully added";
	}
	
	
	
	
	@GetMapping("/getall")
	public List<Student> addstud(){
		
		
		return student;
		
	}
	

	

}
