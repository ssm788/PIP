package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.TbUserMaster;
import com.example.demo.model.UserRoleMapping;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRoleRepository userRoleRepository;
	 public UserResponseDto login(UserDto userDto) {
		    try {
		    	TbUserMaster user = userRepository.findByEmailAddressAndPassword(userDto.getEmail(), userDto.getPassword());
		    		System.out.println("userRes"+user);
		    	UserResponseDto userResponseDto=null;
		    	if(user==null) {
		    		return userResponseDto;
		    		}else {
		    			userResponseDto=new UserResponseDto();
		    			UserRoleMapping userRoleMapping=userRoleRepository.getUserRole(user.getIduser());
			    		System.out.println("user role name : "+userRoleMapping.getTbRoleMaster().getRole_name());
			    		userResponseDto.setEmail(user.getEmail());
			    		userResponseDto.setUserName(user.getUserName());
			    			return userResponseDto;
		    		}
		    } catch (Exception e) {
		    		e.printStackTrace();
		     return null;
		    }
		  }
	

}
