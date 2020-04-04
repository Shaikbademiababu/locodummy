package com.c2s.loginservice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = LoginUserData.class)
public class LoginUserData {
	
	private String firstName;
	private String password;
	
	public LoginUserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginUserData(String firstName, String password) {
		super();
		this.firstName = firstName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUserData {firstName=" + firstName + ", password=" + password + "}";
	}
	
	
}
