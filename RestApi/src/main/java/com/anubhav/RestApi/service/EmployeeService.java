package com.anubhav.RestApi.service;

import com.anubhav.RestApi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theEmployeeId);
    Employee save(Employee theEmployee);
    void deleteById(int theEmployeeId);

}
