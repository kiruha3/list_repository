package com.kiruha3.listfirst.refactorcoursework.controller;


import com.kiruha3.listfirst.refactorcoursework.Employee;

public interface EmployeeInterface {
    void addEmployee(Employee employee);

    void removeToNumEmployee(Integer i);

    Employee findToNumEmployee(Integer i);

    String allEmployee();

    String findEmployee(Employee employee);

    String removeEmployee(Employee employee);
}
