
package com.example.demo.servicves;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.models.Employee;
import com.example.demo.repo.MyRepo;


@Service
public class MyServices {

    @Autowired
    private MyRepo repo;

    // 1. Get All Employees
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // 2. Get Employee By ID
    public Employee getEmployeeById(int id) {
        return repo.findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with ID: " + id
                    )
                );
    }

    // 3. Add Employee
    public Employee addEmployee(Employee emp) {
        if (repo.existsById(emp.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Employee ID already exists: " + emp.getId()
            );
        }
        return repo.save(emp);
    }

    // 4. Update Employee
    public Employee updateEmployee(int id, Employee emp) {
        Employee existing = getEmployeeById(id);

        existing.setName(emp.getName());
        existing.setAge(emp.getAge());
        existing.setSalary(emp.getSalary());
        existing.setDesig(emp.getDesig());

        return repo.save(existing);
    }

    // 5. Delete Employee By ID
    public String deleteEmployeeById(int id) {
        Employee existing = getEmployeeById(id);
        repo.delete(existing);
        return "Employee deleted successfully";
    }

    // 6. Delete All Employees
    public String deleteAllEmployees() {
        repo.deleteAll();
        return "All employees deleted successfully";
    }

    // 7. Count Employees
    public long countEmployees() {
        return repo.count();
    }
}
