package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.cookingUsers;

public interface cookInterface extends JpaRepository<cookingUsers,Integer> {

	Optional<cookingUsers> findByEmail(String email);

	
}
