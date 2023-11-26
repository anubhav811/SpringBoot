package com.anubhav.RestApi.rest;

import com.anubhav.RestApi.entity.Employee;
import com.anubhav.RestApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID){
        Employee theEmployee =  employeeService.findById(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found : " + employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // if an id is passed in json , it should be set to 0 , to force save as a new item
        // instead of update
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteById(@PathVariable int employeeID){
        Employee theEmployee =  employeeService.findById(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found : " + employeeID);
        }
        employeeService.deleteById(employeeID);
        return "Deleted Employee id : " + employeeID;
    }
}
