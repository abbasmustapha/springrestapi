package com.mab.springrestapi.service;

import com.mab.springrestapi.model.Employee;
import com.mab.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository ;

    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee= eRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee not found for id "+ id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
        System.out.println("Employee with id " + id + "deleted");
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name,String location) {
        return eRepository.findByNameAndLocation(name,location);
    }
}
