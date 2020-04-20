package com.Course.RegisterationProgram.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.Course.RegisterationProgram.Exception.UserNotFoundException;
import com.Course.RegisterationProgram.dao.UserRepository;
import com.Course.RegisterationProgram.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository UserRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		//UserService service=Mockito.mock(UserService.class);
	}

	@Test
	public void saveTest() {
		User s = new User();
		s.setName("Roopal");
		Mockito.when(UserRepository.save(s)).thenReturn(s);
		User user = userService.saveOrUpdate(s);
		assertEquals(user.getName(), "Roopal");
	}

	public List<User> setUsers() {
		List<User> users = new ArrayList<User>();
		User u1 = new User(101, "abc", "123456789");
		User u2 = new User(102, "xyz", "923456789");
		users.add(u1);
		users.add(u2);
		return users;
	}

	@Test
	public void getAllUsersTest() {
		List<User> users = setUsers();
		Mockito.when(UserRepository.findAll()).thenReturn(users);

		List<User> userFound = userService.getAllUsers();
		assertEquals(userFound.size(), 2);

	}

	@Test
	public void getUserByIdTest() {
		Optional<User> u1 = Optional.of(new User(101, "abc", "123456789"));
		Mockito.when(UserRepository.findById(101)).thenReturn(u1);

		User s = userService.getUserById(101);
		assertEquals(s.getName(), "abc");

	}
	
	@Test(expected=UserNotFoundException.class)
	public void getUserByIdNullTest() {
		Mockito.when(UserRepository.findById(Matchers.anyInt())).thenReturn(null);

		User s = userService.getUserById(101);
		assertEquals(s.getName(), "abc");

	}
	
	@Test(expected=UserNotFoundException.class)
	public void getUserByIdExceptionTest() {
		Mockito.when(UserRepository.findById(101)).thenThrow(UserNotFoundException.class);
		
		User s = userService.getUserById(101);
		assertEquals(s.getName(), "abc");
	}
}
