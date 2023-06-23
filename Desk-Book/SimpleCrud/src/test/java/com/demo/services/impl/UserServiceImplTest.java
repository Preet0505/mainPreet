package com.demo.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.model.User;
import com.demo.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private  UserRepository userRepository;
	
	private UserServiceImpl userServiceImpl;
	
	private User user;
	
	private List<User> u;
	
	@BeforeEach
	void setUp() throws Exception {
		userServiceImpl=new UserServiceImpl(this.userRepository);
		user = User.builder()
				.id(0)
				.name("Preet")
				.email("preetpatel554@gamil.com")
				.build();
		user =User.builder()
				.id(1)
				.name("Ronak")
				.email("ronak@gamil.com")
				.build();
		
		List<User> u = new ArrayList<>();
				u.add(User.builder()
						.id(0)
						.name("Jacky")
						.email("jacky@gmail.com")
						.build());
				u.add(User.builder()
						.id(1)
						.name("Abhi")
						.email("Abhi@gmail.com")
						.build());
				u.add(User.builder()
						.id(2)
						.name("Rupam")
						.email("Rupam@gmail.com")
						.build());
		
	}

	@Test
	void testAdd() {
		mock(User.class);
		mock(UserServiceImpl.class);
		when(this.userRepository.save(user)).thenReturn(user);
		User add = this.userServiceImpl.add(user);
		System.out.println(add);
		assertEquals(user, add);
	}

	@Test
	void testGetAll() {
//		List<User> user=new ArrayList<>();
//		user.add(new User(1,"Preeti","preetpatel5543@gmail.com"));
//		user.add(new User(2,"Ronko","ronak5543@gmail.com"));
		mock(User.class);
		mock(UserServiceImpl.class);
		when(this.userRepository.findAll()).thenReturn(u);
		List<User> getAllUser = userServiceImpl.getAll();
		System.out.println(getAllUser);
		assertEquals(user, getAllUser);
		
	}

	@Test
//	@BeforeEach
	void testGetUser() {
		mock(User.class);
		mock(UserServiceImpl.class);
		when(this.userRepository.findById(0)).thenReturn(Optional.of(user));
		User getUser=userServiceImpl.getUser(0);
		System.out.println(getUser);
		assertEquals(user, getUser);
	}

	@Test
	void testDelete() {
		mock(User.class);
		mock(UserServiceImpl.class);
		//when(this.userRepository.findById(1)).thenReturn(Optional.of(user));
		this.userServiceImpl.delete(0);
		user=this.userRepository.findById(1).orElse(null);
		boolean flag;
		if(user==null) {
			flag=false;
		}
		else
			flag=true;
		
		assertFalse(flag);
	}

	@Test
	void testUpdate() {
		mock(User.class);
		mock(UserServiceImpl.class);
		
		
	}

}
