package com.costin.hibernateproject;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    Employee retrieveEmployeeById(int id);
    List<Employee> queryObjectsByCompany(String companyName);
    void deleteEmployeeById(int id);
    void close();

}
