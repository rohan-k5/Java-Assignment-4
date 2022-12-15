package com.example.JavaAssignment.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.JavaAssignment.entity.Employees;
import com.example.JavaAssignment.repository.EmployeeRepository;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

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
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEmployees2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.JavaAssignment.service.EmployeeService.getEmployees(EmployeeService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        when(employeeRepository.findById((Integer) any())).thenReturn(Optional.empty());
        employeeService.getEmployees(1);
    }

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
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.JavaAssignment.service.EmployeeService.update(EmployeeService.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        Employees employees = new Employees();
        employees.setAge(1);
        employees.setId(1);
        employees.setName("Name");
        employees.setSalary(1);
        when(employeeRepository.save((Employees) any())).thenReturn(employees);
        when(employeeRepository.findById((Integer) any())).thenReturn(Optional.empty());

        Employees employees1 = new Employees();
        employees1.setAge(1);
        employees1.setId(1);
        employees1.setName("Name");
        employees1.setSalary(1);
        employeeService.update(employees1);
    }

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
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EmployeeService.employeeRepository

        (new EmployeeService()).setEmployeeRepository(mock(EmployeeRepository.class));
    }
}

