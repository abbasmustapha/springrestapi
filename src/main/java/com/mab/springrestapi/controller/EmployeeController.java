package com.mab.springrestapi.controller;

import com.mab.springrestapi.model.Employee;
import com.mab.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService eService;


    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return eService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable Long id){
        return "Fetching the employee details for the id " + id;
    }

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        return "Saving the employee details to the DataBase"+employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("Update in progress id :"+id + "  ("+employee+")");
        return employee;
    }

    // localhost:8080/employees?id=123&name=martin
    @DeleteMapping("/employees")
    public String deleteEmployee( @RequestParam("id") Long id,
                                  @RequestParam("name") String name){
        return "delete employee id " + id + " name " + name;
    }

}
