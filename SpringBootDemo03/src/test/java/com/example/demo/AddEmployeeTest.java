
package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Employee;
import com.example.demo.repo.MyRepo;
import com.example.demo.servicves.MyServices;

@ExtendWith(MockitoExtension.class)
class MyServicesTest {

    @Mock
    private MyRepo repo;

    @InjectMocks
    private MyServices service;

    // TEST CASE 1: Add Employee Successfully
    @Test
    void testAddEmployee_Success() {

        // Arrange
        Employee emp = new Employee(
                101, "Thanesh", 25, 50000, "Developer");

        when(repo.existsById(101)).thenReturn(false);
        when(repo.save(emp)).thenReturn(emp);

        // Act
        Employee result = service.addEmployee(emp);

        // Assert
        assertNotNull(result);
        assertEquals(101, result.getId());
        assertEquals("Thanesh", result.getName());
        assertEquals(50000, result.getSalary());

        verify(repo, times(1)).existsById(101);
        verify(repo, times(1)).save(emp);
    }

    // TEST CASE 2: Duplicate Employee ID
    @Test
    void testAddEmployee_DuplicateId() {

        // Arrange
        Employee emp = new Employee(
                101, "Thanesh", 25, 50000, "Developer");

        when(repo.existsById(101)).thenReturn(true);

        // Act + Assert
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> service.addEmployee(emp)
        );

        assertEquals(
                HttpStatus.CONFLICT,
                exception.getStatusCode()
        );

        assertEquals(
                "Employee ID already exists: 101",
                exception.getReason()
        );

        verify(repo, times(1)).existsById(101);
        verify(repo, never()).save(any(Employee.class));
    }
}
