package com.example.javaassignment.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.javaassignment.entity.Employees;
import com.example.javaassignment.repository.EmployeeRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeService#save(Employees)}
     */
    @Test
    void testSave() {
        Employees employees = new Employees();
        employees.setAge(1);
        employees.setId(1);
        employees.setName("Name");
        employees.setSalary(1);
        when(employeeRepository.save((Employees) any())).thenReturn(employees);

        Employees employees1 = new Employees();
        employees1.setAge(1);
        employees1.setId(1);
        employees1.setName("Name");
        employees1.setSalary(1);
        assertSame(employees, employeeService.save(employees1));
        verify(employeeRepository).save((Employees) any());
    }

    /**
     * Method under test: {@link EmployeeService#getEmployees(int)}
     */
    @Test
    void testGetEmployees() {
        Employees employees = new Employees();
        employees.setAge(1);
        employees.setId(1);
        employees.setName("Name");
        employees.setSalary(1);
        Optional<Employees> ofResult = Optional.of(employees);
        when(employeeRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(employees, employeeService.getEmployees(1));
        verify(employeeRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link EmployeeService#getEmployees(int)}
     */


    /**
     * Method under test: {@link EmployeeService#update(Employees)}
     */
    @Test
    void testUpdate() {
        Employees employees = new Employees();
        employees.setAge(1);
        employees.setId(1);
        employees.setName("Name");
        employees.setSalary(1);
        Optional<Employees> ofResult = Optional.of(employees);

        Employees employees1 = new Employees();
        employees1.setAge(1);
        employees1.setId(1);
        employees1.setName("Name");
        employees1.setSalary(1);
        when(employeeRepository.save((Employees) any())).thenReturn(employees1);
        when(employeeRepository.findById((Integer) any())).thenReturn(ofResult);

        Employees employees2 = new Employees();
        employees2.setAge(1);
        employees2.setId(1);
        employees2.setName("Name");
        employees2.setSalary(1);
        assertSame(employees1, employeeService.update(employees2));
        verify(employeeRepository).save((Employees) any());
        verify(employeeRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link EmployeeService#update(Employees)}
     */


    /**
     * Method under test: {@link EmployeeService#delete(int)}
     */
    @Test
    void testDelete() {
        doNothing().when(employeeRepository).deleteById((Integer) any());
        employeeService.delete(1);
        verify(employeeRepository).deleteById((Integer) any());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link EmployeeService}
     *   <li>{@link EmployeeService#setEmployeeRepository(EmployeeRepository)}
     * </ul>
     */

}

