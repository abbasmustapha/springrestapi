package com.mab.springrestapi.service;

import com.mab.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
}
