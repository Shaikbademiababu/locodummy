package com.c2s.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c2s.loginservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	//Role findByRole(String role);
}
