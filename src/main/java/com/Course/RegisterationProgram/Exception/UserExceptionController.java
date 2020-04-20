package com.Course.RegisterationProgram.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserExceptionController {
	
	  @ExceptionHandler(value = UserNotFoundException.class)
	   public ResponseEntity<Object> Userexception(UserNotFoundException exception) {
	      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}
}
