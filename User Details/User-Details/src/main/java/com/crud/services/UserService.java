package com.crud.services;

import java.util.List;

import com.crud.entity.User;

public interface UserService {

	String add(User user);

	List<User> view(User user);

	User getUserById(int id);

	String delete(int id);

	String update(int id, User user);

}
