package com.anubhav.cruddemo.dao;

import com.anubhav.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define the field for entity manager
    private final EntityManager entityManager;

    // inject entity manager
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        // TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);

        // sort the results by alphabet order of last name
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName ASC",Student.class);
        // return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        // set the query parameter
        query.setParameter("theData",lastName);

        // return query results
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student studentToBeDeleted = entityManager.find(Student.class,id);
        if(studentToBeDeleted != null){
            entityManager.remove(studentToBeDeleted);
        }else{
            System.out.println("Student doesnt exist");
        }
    }

    @Override
    @Transactional
    public void deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println("Number of rows deleted : " + numRowsDeleted);
    }


}
