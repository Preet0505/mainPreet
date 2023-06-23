package com.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.User;
import com.crud.repository.UserRepo;

@Service
public class UserServicesImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String add(User user) {
		userRepo.save(user);
		return "User added successfully";
	}

	@Override
	public List<User> view(User user) {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}

	@Override
	public String delete(int id) {
		User u = userRepo.findById(id).get();
		if(u == null)
			return "Please enter valid id...";
		else
			userRepo.deleteById(id);
			return "Deleted successfully";
	}

	@Override
	public String update(int id,User user) {
		User u = userRepo.findById(id).get();
		if(u==null)
			return "Enter valid id...";
		else
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			userRepo.save(u);
			return "Successfully save";
			
	}
										
	

}
