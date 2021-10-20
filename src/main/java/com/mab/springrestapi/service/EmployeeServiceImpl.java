package com.mab.springrestapi.service;

import com.mab.springrestapi.model.Employee;
import com.mab.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository ;

    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }
}
