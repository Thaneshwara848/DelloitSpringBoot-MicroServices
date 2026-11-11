package com.example.demo.Exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
