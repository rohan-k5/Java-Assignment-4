package com.example.javaassignment.service;



import com.example.javaassignment.entity.Employees;
import com.example.javaassignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public Employees save(Employees employee)
    {
        return employeeRepository.save(employee);
    }
    public  Employees getEmployees(int id)
    {
        return  employeeRepository.findById(id).get();
    }
    public  Employees update(Employees employee)
    {
        Employees emp=employeeRepository.findById(employee.getId()).get();
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setSalary(employee.getSalary());
        return  employeeRepository.save(employee);
    }
    public  Employees delete(int id)
    {
        employeeRepository.deleteById(id);
        return new Employees();
    }
    public  EmployeeRepository getEmployeeRepository(){
        return employeeRepository;
    }
    public  void setEmployeeRepository(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

}
