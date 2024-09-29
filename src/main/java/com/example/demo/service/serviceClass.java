package com.example.demo.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.cookingUsers;
import com.example.demo.repository.cookInterface;

@Service
public class serviceClass implements serviceInterface {

	@Autowired
	cookInterface objrepo;
	
	@Override
	public cookingUsers usersave(String name, String email, String password) {
		// TODO Auto-generated method stub
		cookingUsers obj=new cookingUsers();
		obj.setName(name);
		obj.setEmail(email);
		obj.setPassword(password);
		return objrepo.save(obj);
		
	}

	public boolean validateUser(String email, String password) {
	    Logger logger = LoggerFactory.getLogger(serviceClass.class);

	    if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
	        logger.warn("Validation failed: Wrong email or password");
	        return false;
	    }

	    Optional<cookingUsers> user = objrepo.findByEmail(email);
	    if (user.isPresent() && user.get().getPassword().equals(password)) {
	        return true;
	    } else {
	        logger.warn("Validation failed: Wrong email or password");
	        return false;
	    }
	}

}
