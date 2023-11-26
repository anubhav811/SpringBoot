package com.anubhav.RestApi.dao;

import com.anubhav.RestApi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{

    // define field for entity manager
    private EntityManager entityManager ;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
        // execute query and return result list
        return query.getResultList();
    }

    @Override
    public Employee findById(int theEmployeeId) {
        return entityManager.find(Employee.class, theEmployeeId);
    }
    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theEmployeeId) {
        Employee theEmployee = entityManager.find(Employee.class,theEmployeeId);
        entityManager.remove(theEmployee);
    }
}
