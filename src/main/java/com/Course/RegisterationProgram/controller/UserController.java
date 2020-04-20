package com.Course.RegisterationProgram.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Course.RegisterationProgram.Exception.UserEntity;
import com.Course.RegisterationProgram.entity.User;
import com.Course.RegisterationProgram.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	//http://localhost:8080/Users/1
	@GetMapping("/Users")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	//http://localhost:8080/Users/foos?id=1
	@GetMapping("/Users/foos")
	@ResponseBody
	public String getFoos(@RequestParam(defaultValue = "test",value="idtry") String id) {
	    return "ID: " + id;
	}
	
	@GetMapping("/Users/{id}")
	private ResponseEntity<UserEntity> getUser(@PathVariable("id") int id) {
//		try {
			User u = userService.getUserById(id);
			return new ResponseEntity<UserEntity>(new UserEntity(u), HttpStatus.OK);
/*		} catch (UserNotFoundException e) {
			return new ResponseEntity<UserEntity>(new UserEntity(new User(),e.getMessage()), HttpStatus.NOT_FOUND);
		}
*/	}

	@DeleteMapping("/Users/{id}")
	private void deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
	}

	/*
	 * from postman send Method->POST ;Content-Type->application/json ; in body
	 * ->raw as the json request body ; return status:201 created in header response
	 * we will get the path as Location →http://localhost:8080/users/{generatedId}
	 */
	@PostMapping("/Users")
	private ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userService.saveOrUpdate(user);
		URI location1 = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		//savedUser.setSelfUrl(location1.toString());
		return ResponseEntity.created(location1).body(savedUser);

	}

	/*
	 * {
	 * 
	 * "name": "Roopal", "address" : { "street": "gwl", "city": "ABC", "state":
	 * "Maharashtra", "pincode": "1234" }, "contact": "Ranga" } SELECT * FROM
	 * ADDRESS ; SELECT * FROM USER
	 */
}
