package com.example.JavaAssignment.controller;

import com.example.JavaAssignment.entity.Employees;
import com.example.JavaAssignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;

    @GetMapping(path ="/{id}")
    public Employees getEmployees(@PathVariable int id) {
        return employeeservice.getEmployees(id);

    }

    @PostMapping
    public Employees addEmployees(@RequestBody Employees employee) {
        return employeeservice.save(employee);
    }

    @PutMapping
    public Employees updateEmployees(@RequestBody Employees employee) {
        return employeeservice.update(employee);
    }

    @DeleteMapping
    public Employees deleteEmployees(@RequestBody Employees employee) {
        return employeeservice.delete(employee.getId());
    }
}