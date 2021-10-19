package com.mab.springrestapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public String getEmployees(){
        return "displaying the list of employees";
    }

    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable Long id){
        return "Fetching the employee details for the id " + id;
    }

    // localhost:8080/employees?id=123&name=martin
    @DeleteMapping("/employees")
    public String deleteEmployee( @RequestParam("id") Long id,
                                  @RequestParam("name") String name){
        return "delete employee id " + id + " name " + name;
    }

}
