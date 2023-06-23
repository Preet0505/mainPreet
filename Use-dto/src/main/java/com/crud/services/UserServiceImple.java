package com.crud.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.repo.Repository;
import com.crud.user.User;
import com.crud.user_dto.UserDto;

@Service
public class UserServiceImple implements UserService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Repository userRepo;
	
	
	@Override
	public String add(UserDto userDto) {
		
		User user = userDtoToUser(userDto);
		userRepo.save(user);
		return "User added successfully";
	}



	@Override
	public List<UserDto> view() {
		List<UserDto> userDto = userRepo.findAll().stream().map((x)->userToUserDto(x)).collect(Collectors.toList());
		return userDto;
		
	}
	
	
	@Override
	public UserDto getById(int id) {
		return userToUserDto(userRepo.findById(id).get());
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public String deleteById(int id) {
//		User u = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found.."));
//		if(u==null)
//			return "User not found";
//		userRepo.delete(u);
//			return "Delete Successfully";
		
		User user = userRepo.getById(id);
		//return deleteById(id);
		 userRepo.delete(user);
		 return "success";
	}

	
	

	@SuppressWarnings("deprecation")
	@Override
	public String update(int id, User user) {
		User u = userRepo.getById(id);
		if(u==null)
			return "Enter valid id...";
		else
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			userRepo.save(u);
		return "Update successfully";
	}
	
	
	
	
	private UserDto userToUserDto(User user) {		
		UserDto userDto = modelMapper.map(user, UserDto.class);
		
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
		return userDto;
	}

	private User userDtoToUser(UserDto userDto) {
		
		User user = modelMapper.map(userDto, User.class);
		
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
		return user;
	}



}
