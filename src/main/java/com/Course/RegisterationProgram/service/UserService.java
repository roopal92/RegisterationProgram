package com.Course.RegisterationProgram.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Course.RegisterationProgram.Exception.UserNotFoundException;
import com.Course.RegisterationProgram.dao.UserRepository;
import com.Course.RegisterationProgram.entity.User;

@Service
public class UserService {

	    @Autowired
	    UserRepository UserRepository;

	    public List<User> getAllUsers() {
	        List<User> Users = new ArrayList<User>();
	        UserRepository.findAll().forEach(User -> Users.add(User));
	        return Users;
	    }

	    /*public User getUserById(int id) {
	        return UserRepository.findById(id).get();
	    }*/

	    public User getUserById(int id) {
	        Optional<User> receivedUser = UserRepository.findById(id);
	        	if(receivedUser!=null && receivedUser.isPresent())
		        	return receivedUser.get();
		        else
		        	throw new UserNotFoundException();
	        
	    }

	    public User saveOrUpdate(User User) {
	       return UserRepository.save(User);
	    }

	    public void delete(int id) {
	        UserRepository.deleteById(id);
	    }
}
