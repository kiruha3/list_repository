package com.kiruha3.list.refactorcoursework.controller;


import com.kiruha3.list.refactorcoursework.Employee;
import com.kiruha3.list.selfexceptions.EmployeeAlreadyAddedException;
import com.kiruha3.list.selfexceptions.EmployeeNotFoundException;
import com.kiruha3.list.selfexceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceimpl) {
        this.employeeServiceImpl = employeeServiceimpl;
    }

    @GetMapping()
    public String logInPage() {
        return "Приветствую вас на стартовой странице";
    }

    @GetMapping(path = "/add")
    public Employee addEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam("lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            System.out.println("Сотрудник успешно добавлен ");
            return employeeServiceImpl.addEmployee(employee);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("ArrayIsFull ");
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("EmployeeAlreadyAdded");
        }
        return null;
    }

    @GetMapping(path = "/find")
    public Employee findEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                               @RequestParam(value = "lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            return employeeServiceImpl.findEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println("EmployeeNotFound");
        }
        return null;
    }


    @GetMapping(path = "/remove")
    public Employee removeEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            return employeeServiceImpl.removeEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println("EmployeeNotFound");
        }
        return null;
    }

    @GetMapping(path = "/all")
    public Collection<Employee> allEmployer() {
        return employeeServiceImpl.allEmployee();
    }

}
