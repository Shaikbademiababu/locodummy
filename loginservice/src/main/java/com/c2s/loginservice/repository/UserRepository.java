package com.c2s.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2s.loginservice.model.User;



public interface UserRepository extends JpaRepository<User, Long> {

	//User findByEmail(String email);
	User findByFirstName(String firstName);
}
