package com.example.javaassignment.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeesTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Employees}
     *   <li>{@link Employees#setAge(int)}
     *   <li>{@link Employees#setId(int)}
     *   <li>{@link Employees#setName(String)}
     *   <li>{@link Employees#setSalary(int)}
     *   <li>{@link Employees#getAge()}
     *   <li>{@link Employees#getId()}
     *   <li>{@link Employees#getName()}
     *   <li>{@link Employees#getSalary()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Employees actualEmployees = new Employees();
        actualEmployees.setAge(1);
        actualEmployees.setId(1);
        actualEmployees.setName("Name");
        actualEmployees.setSalary(1);
        assertEquals(1, actualEmployees.getAge());
        assertEquals(1, actualEmployees.getId());
        assertEquals("Name", actualEmployees.getName());
        assertEquals(1, actualEmployees.getSalary());
    }
}

