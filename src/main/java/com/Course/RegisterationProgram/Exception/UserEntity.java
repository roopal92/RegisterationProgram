package com.Course.RegisterationProgram.Exception;

import com.Course.RegisterationProgram.entity.User;

public class UserEntity {

	User user;
	String message;
	
	
	public UserEntity() {
		super();
	}
	public UserEntity(User user, String message) {
		super();
		this.user = user;
		this.message = message;
	
	}
	public UserEntity(User user) {
		super();
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
