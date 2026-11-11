package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface MyEmployeeRepo extends JpaRepository<Employee, Integer> {
	
	//CRUDRepository----> only we can do CRUD 
	//CRUDRepository ---------- > JpaRepository --- 10000  pagination . sorting 
}
