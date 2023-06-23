package com.crud.services;

import java.util.List;

import com.crud.user.User;
import com.crud.user_dto.UserDto;

public interface UserService {

	String add(UserDto userdto);


	List<UserDto> view();


	UserDto getById(int id);


	String deleteById(int id);


	String update(int id, User user);
	
	
	
	
	
	
	
	
//	UserDto userToUserDto(User user);
//	
//	User userDtoToUser(UserDto userDto);
	
}
