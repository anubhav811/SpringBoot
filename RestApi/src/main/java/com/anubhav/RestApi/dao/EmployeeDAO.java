package com.anubhav.RestApi.dao;


import com.anubhav.RestApi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee theEmployee);
    void deleteById(int theEmployeeId);
}
