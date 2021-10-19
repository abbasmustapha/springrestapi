package com.mab.springrestapi.controller;

import com.mab.springrestapi.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.absent:val default}")
    private String appVelDef;

    @GetMapping("/version")
    public String getAppDetails(){
        return appName + " - " + appVersion+ "("+appVelDef+")";
    }


    @GetMapping("/employees")
    public String getEmployees(){
        return "displaying the list of employees";
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
