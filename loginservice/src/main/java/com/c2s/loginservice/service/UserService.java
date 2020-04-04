package com.c2s.loginservice.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.c2s.loginservice.model.LoginUserData;
import com.c2s.loginservice.model.Role;
import com.c2s.loginservice.model.User;
import com.c2s.loginservice.repository.RoleRepository;
import com.c2s.loginservice.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
   // private RoleRepository roleRepository;
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

	/*
	 * public User findUserByEmail(String email) { return
	 * userRepository.findByEmail(email); }
	 */

    public User findUserByUserName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public User saveUser(User user) {
    	User userdata = new User();
    	userdata.setFirstName(user.getFirstName());
    	//login.setPassword(user.getPassword());
    	userdata.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       // user.setActive(true);
       // Role userRole = roleRepository.findByRole("ADMIN");
        //user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(userdata);
    }

}
