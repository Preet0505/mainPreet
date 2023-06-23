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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.User;
import com.crud.services.UserService;

@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return userService.add(user);
	}
	
	@GetMapping("/view-all")
	public List<User> viewAll(User user){
		return userService.view(user);
		
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return userService.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateById(@PathVariable int id,@RequestBody User user) {
		return userService.update(id,user);
	}
}
