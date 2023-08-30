package com.kiruha3.list.refactorcoursework.controller;


import com.kiruha3.list.refactorcoursework.Employee;
import com.kiruha3.list.selfexceptions.EmployeeAlreadyAddedException;
import com.kiruha3.list.selfexceptions.EmployeeNotFoundException;
import com.kiruha3.list.selfexceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String addEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam("lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            employeeServiceImpl.addEmployee(employee);
            return "Сотрудник успешно добавлен ";
        } catch (EmployeeStorageIsFullException e) {
            return "ArrayIsFull ";
        } catch (EmployeeAlreadyAddedException e) {
            return "EmployeeAlreadyAdded";
        }
    }


    @GetMapping(path = "/find")
    public String findEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                               @RequestParam(value = "lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            return employeeServiceImpl.findEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound";
        }
    }


    @GetMapping(path = "/remove")
    public String removeEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            return employeeServiceImpl.removeEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound";
        }
    }

    @GetMapping(path = "/all")
    public String allEmployer() {
        return employeeServiceImpl.allEmployee().toString();
    }

}
