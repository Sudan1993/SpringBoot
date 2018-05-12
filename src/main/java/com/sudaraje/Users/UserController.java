package com.sudaraje.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudaraje.topics.Topic;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	@ResponseBody
	public ResponseEntity<Object> insertUser(@RequestBody Users user) {
		System.out.println(user.toString());
		System.out.println(userService.findByUsername(user.getUsername()).size());
		if(userService.findByUsername(user.getUsername()).size()!=0){
			return new ResponseEntity<>("UserName already exists !!!",HttpStatus.NOT_ACCEPTABLE);
		}
		else {
			userService.insertUser(user);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
	}
	
}