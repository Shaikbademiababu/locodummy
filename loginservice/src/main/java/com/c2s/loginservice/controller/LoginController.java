package com.c2s.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c2s.loginservice.model.LoginUserData;
import com.c2s.loginservice.model.User;
import com.c2s.loginservice.service.UserService;
@RestController
@RequestMapping(value = "registration")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	  @Autowired 
	  private UserService userService;
	 
	

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createNewUser(@RequestBody User user) {
    	System.out.println(user.toString());
        User userExists = userService.findUserByUserName(user.getFirstName());
        if (userExists != null) {
        }
         else {
        	try {
            userService.saveUser(user);
        	}catch(Exception e) {
        		System.out.println(e);
        	}
        }
        return "User has been registered successfully";
    }

	

}
