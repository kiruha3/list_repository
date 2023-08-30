package com.kiruha3.list.refactorcoursework.controller;


import com.kiruha3.list.refactorcoursework.Employee;
import com.kiruha3.list.refactorcoursework.EmployeeService;
import com.kiruha3.list.selfexceptions.EmployeeAlreadyAddedException;
import com.kiruha3.list.selfexceptions.EmployeeNotFoundException;
import com.kiruha3.list.selfexceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
    private final EmployeeService employeeService;

    public EmployeeServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employeeService.employee.size() == employeeService.maxCountEmployee) {
            throw new EmployeeStorageIsFullException();
        } else if (employeeService.employee.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else
            employeeService.employee.add(employee);
    }


    @Override
    public String allEmployee() {
        return employeeService.employee.toString();

    }

    @Override
    public String findEmployee(Employee employee) {
        if (employeeService.employee.contains(employee)) {
            return employeeService.employee.get(employeeService.employee.indexOf(employee)).toString();
        } else
            throw new EmployeeNotFoundException();
    }

    @Override
    public String removeEmployee(Employee employee) {
        if (employeeService.employee.contains(employee)) {
            return employeeService.employee.remove(employeeService.employee.indexOf(employee)).toString();
        } else
            throw new EmployeeNotFoundException();
    }


}
