package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employee;

public interface MyRepo extends JpaRepository<Employee, Integer> {

}