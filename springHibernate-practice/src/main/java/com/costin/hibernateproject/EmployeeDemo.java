package com.costin.hibernateproject;

import java.util.List;

public class EmployeeDemo {
    public static void main(String[] args) {
        EmployeeServiceImplementation serviceImplementation =
                new EmployeeServiceImplementation();


        /*
        serviceImplementation.saveEmployee(new Employee(
                "Costin",
                "Cinjau",
                "Google"
        ));

        serviceImplementation.saveEmployee(new Employee(
                "Claudiu",
                "Cinjau",
                "Facebook"
        ));

        serviceImplementation.saveEmployee(new Employee(
                "Alessia",
                "Cinjau",
                "Google"
        ));
         */

        /*
        Employee theEmployee =
                serviceImplementation.retrieveEmployeeById(1);

        System.out.println(theEmployee);
        */

        /*
        List<Employee> employees =
                serviceImplementation.queryObjectsByCompany("Google");
        System.out.println(employees);
         */

        serviceImplementation.deleteEmployeeById(2);

        serviceImplementation.close();
    }
}
