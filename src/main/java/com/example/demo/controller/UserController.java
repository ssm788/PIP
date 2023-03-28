package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.JwtRequest;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	private JwtService jwtGenerator;
	 @PostMapping("/v1/auth/authentication")
	  public ResponseEntity<UserResponseDto> getJwtToken(@RequestBody UserDto userDto) {
	    try {
	    	UserResponseDto userResponseDto =userService.login(userDto);
	    	
	    	//System.out.println("User Status: "+userResponseDto.getEmail());
	    	String token=null;
	    	if(userResponseDto!=null) {
	    	 token =jwtGenerator.generateToken(userDto.getEmail());
	    	 userResponseDto.setToken(token);
	    	 System.out.println("jwtGenerator.generateToken(user)"+token);
	    	 return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
	    	}
	    	else {
	    		 return new ResponseEntity<>(userResponseDto, HttpStatus.BAD_REQUEST);
	    	}
	   
	     
	    } catch (Exception e) {
	    	e.printStackTrace();
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
