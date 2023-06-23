package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.services.UserService;
import com.crud.user.User;
import com.crud.user_dto.UserDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	@PostMapping("/add-user")
	public String addUser(@Valid @RequestBody UserDto userdto) {
		return userservice.add(userdto);
		
	}
	
	@GetMapping("/get-all-user")
	public List<UserDto> viewAllUser(){
		return userservice.view(); 
	}
	
	
	@GetMapping("/{id}")
	public UserDto getbyId(@PathVariable int id) {
		return userservice.getById(id);
	}
	
	//@DeleteMapping("/delete/{id}")
	@DeleteMapping("/delete")
	public String deleteById(int id) {
		return userservice.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateById(@PathVariable int id,@Valid @RequestBody User user) {
		return userservice.update(id,user);
	}
}
