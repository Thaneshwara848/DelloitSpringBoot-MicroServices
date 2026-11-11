package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employee;

public interface MyRepo extends JpaRepository<Employee, Integer> {
	// findALl 
	//findById
	//save
	//update
	//deleteAll
	//DeleteById
	//etc....!
	// 15-20 Apis 
	// 10-20% logics we were writing , rest all inbuild methods from JPA 
}

// JDBC-------------> Hiberate ------> SPRINGBOOT DATA JPA  