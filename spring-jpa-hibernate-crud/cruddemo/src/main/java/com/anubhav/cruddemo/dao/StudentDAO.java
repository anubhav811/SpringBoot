package com.anubhav.cruddemo.dao;

import com.anubhav.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    // CREATE
    void save(Student theStudent);

    // READ
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    // UPDATE
    void update(Student student);

    // DELETE
    void delete(Integer id);

    void deleteAll();

}
