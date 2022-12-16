package com.example.javaassignment.controller;

import com.example.javaassignment.entity.Employees;
import com.example.javaassignment.service.EmployeeService;
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
    @ResponseBody
    public Employees addEmployees(@RequestBody Employees employeeId) {
        return employeeservice.save(employeeId);
    }

    @PutMapping
    @ResponseBody
    public Employees updateEmployees(@RequestBody Employees employeeId) {
        return employeeservice.update(employeeId);
    }

    @DeleteMapping
    @ResponseBody
    public Employees deleteEmployees(@RequestBody Employees employeeId) {
        return employeeservice.delete(employeeId.getId());
    }
}