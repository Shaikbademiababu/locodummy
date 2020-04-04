package com.c2s.loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationContext;

import com.c2s.loginservice.model.User;
import com.c2s.loginservice.service.UserService;
@EnableBinding(Sink.class)
@SpringBootApplication
@EnableDiscoveryClient
public class LoginserviceApplication implements CommandLineRunner{
	@Autowired
    private ApplicationContext applicationContext;
	private UserService userService;

	public static void main(String[] args) {
		 SpringApplication.run(LoginserviceApplication.class, args);
	
	}
	 @Override
	    public void run(String... args) throws Exception {

	        System.out.println(applicationContext.getDisplayName());
	        System.out.println(applicationContext.getId());

	         userService = applicationContext.getBean(UserService.class);
	        
	    }
	
	@StreamListener(target = Sink.INPUT)
	public void processRegisterEmployees(User user) {
		System.out.println("Employees Registered by Client " + user);
		
		User userExists = userService.findUserByUserName(user.getFirstName());
        if (userExists != null) {
        	System.out.println("user exists");
        }
         else {
        	try {
        		System.out.println("saving user");
            userService.saveUser(user);
        	}catch(Exception e) {
        		System.out.println(e);
        	}
        }
	 
	}

}
