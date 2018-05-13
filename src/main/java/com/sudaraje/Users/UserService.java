package com.sudaraje.Users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//create new user
	//validate existing user
	
	public List<Users> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		System.out.println(users);
		return users;
	}

	public void insertUser(Users user) {
		// TODO Auto-generated method stub
		System.out.println(user.toString());
		userRepository.save(user);
	}

	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		if(userRepository.findByUsername(username).size()!=0) {
			//remove the list of users with the specified username
			List<Users> userList = userRepository.findByUsername(username);
			userList.forEach(x -> userRepository.delete(x));
		}else {
			System.out.println("no user found with the specified name");
		}
			
		
	}
	
}
