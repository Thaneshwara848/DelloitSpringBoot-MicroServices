package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemo02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo02Application.class, args);
		System.out.println("CRUD with MYSQL ...!");
	}

}
