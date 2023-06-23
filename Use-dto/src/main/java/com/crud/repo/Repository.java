package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.user.User;

public interface Repository extends JpaRepository<User, Integer>{

}
