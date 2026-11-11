package com.example.demo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.models.Employee;
import com.example.demo.repo.MyRepo;
import com.example.demo.servicves.MyServices;

@ExtendWith(MockitoExtension.class)
public class EmployeeIdTest {
	 @Mock
	    private MyRepo repo;

	    @InjectMocks
	    private MyServices service;

	    // TEST CASE 1: Employee Exists
	    @Test
	    void testGetEmployeeById_Success() {

	        // Arrange
	        Employee emp = new Employee(
	                101, "Thanesh", 25, 50000, "Developer");

	        when(repo.findById(101))
	                .thenReturn(Optional.of(emp));

	        // Act
	        Employee result = service.getEmployeeById(101);

	        // Assert
	        assertNotNull(result);
	        assertEquals(101, result.getId());
	        assertEquals("Thanesh", result.getName());
	        assertEquals(50000, result.getSalary());

	        verify(repo, times(1)).findById(101);
	    }

	    // TEST CASE 2: Employee Not Found
	    @Test
	    void testGetEmployeeById_NotFound() {

	        // Arrange
	        when(repo.findById(999))
	                .thenReturn(Optional.empty());

	        // Act + Assert
	        EmployeeNotFoundException exception =
	                assertThrows(
	                    EmployeeNotFoundException.class,
	                    () -> service.getEmployeeById(999)
	                );

	        assertEquals(
	                "Employee not found with ID: 999",
	                exception.getMessage()
	        );

	        verify(repo, times(1)).findById(999);
	    }
	}
