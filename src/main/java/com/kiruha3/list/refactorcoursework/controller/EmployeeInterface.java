package com.kiruha3.list.refactorcoursework.controller;


import com.kiruha3.list.refactorcoursework.Employee;

import java.util.Collection;

public interface EmployeeInterface {
    Employee addEmployee(Employee employee);

    Collection<Employee> allEmployee();

    Employee findEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

}
