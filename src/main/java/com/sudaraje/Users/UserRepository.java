package com.sudaraje.Users;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long>{

	List<Users> findByUsername(String username);
}
