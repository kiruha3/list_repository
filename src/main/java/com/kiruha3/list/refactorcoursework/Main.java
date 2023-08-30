package com.kiruha3.list.refactorcoursework;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //enterEmployer(employeeService.employee);
//        EmployeeService employeeService = new EmployeeService();
//        //employeeService.employee.remove(2);
//        System.out.println(employeeService.employee);
//        Employee men = new Employee("da","ad");
//        employeeService.employee.add(men);
//        System.out.println(employeeService.employee);
    }


    public static void enterEmployer(List<Employee> employee) {
        for (int i = 0; i < employee.size(); i++) {
            System.out.printf("Номер %s = %s%n", i, employee.get(i).toString());
        }
    }


    public static void personalFIO(List<Employee> employee) {
        for (int i = 0; i < employee.size(); i++) {
            System.out.printf("Фамилия: %s Имя: %s Отчетсво: %s %n", employee.get(i).toString());
        }
    }


}