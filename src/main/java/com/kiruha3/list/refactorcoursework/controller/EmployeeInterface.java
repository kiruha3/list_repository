package com.kiruha3.list.refactorcoursework.controller;


import com.kiruha3.list.refactorcoursework.Employee;

public interface EmployeeInterface {
    void addEmployee(Employee employee);

    String allEmployee();

    String findEmployee(Employee employee);

    String removeEmployee(Employee employee);
}
