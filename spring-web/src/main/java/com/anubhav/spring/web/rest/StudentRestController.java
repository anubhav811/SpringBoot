package com.anubhav.spring.web.rest;

import com.anubhav.spring.web.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Anubhav","Chachra"));
        students.add(new Student("Krina","Panchal"));
        students.add(new Student("Anmol","Chachra"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        // check if student id is valid
        if(studentId>=students.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found : " + studentId);
        }
        return students.get(studentId);
    }
}
