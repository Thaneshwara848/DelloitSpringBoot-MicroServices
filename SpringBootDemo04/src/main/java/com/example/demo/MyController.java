package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/dashboard")
	public String dashboard() {
		return "<h1>Hi Welcome to DashBoard Page </h1>";
	}
	
	@GetMapping("/home")
	public String home() {
		return "<h1>Hi Welcome to HOME Page </h1>";
	}
	
}
