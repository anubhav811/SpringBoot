package com.anubhav.cruddemo;

import ch.qos.logback.classic.spi.STEUtil;
import com.anubhav.cruddemo.dao.StudentDAO;
import com.anubhav.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// Getting student object
		int studentId = 1;
		System.out.println("Getting student with id " + studentId);
		// deleting the student
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student by id;
		int studentId = 1;
		System.out.println("Getting student with id 1");
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Aloo"
		myStudent.setFirstName("Aloo");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		// get a list of students with the given lastName
		List<Student> students = studentDAO.findByLastName("Chachra");
		// display the list of students
		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}
	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findAll();
		// display the list of students
		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDao) {

		// create a student object
		System.out.println("Creating the student object...");
		Student student = new Student("Narendra","Modi","namo@gov.in");

		// save the student
		System.out.println("Saving the student...");
		studentDao.save(student);

		// display the id of the student
		int id = student.getId();
		System.out.println("Generated ID of the student : " + id);

		// retrieve the student based on the id
		System.out.println("Retrieving the student with id " + id + " ...");
		Student retrievedObject = studentDao.findById(id);

		// display student
		System.out.println("Printing the found student ....");
		System.out.println(retrievedObject);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students objects

		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Anubhav","Chachra", "anubhav@gmail.com");
		Student tempStudent2 = new Student("Krina","Panchal", "krina@gmail.com");
		Student tempStudent3 = new Student("Yash","Gupta", "yash@gmail.com");

		// save the student objects
		System.out.println("Saving the students ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println(tempStudent1);
		System.out.println(tempStudent2);
		System.out.println(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Anubhav","Chachra",
		"anubhav@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of student
		System.out.println("Saved Student " + tempStudent);
	}

}
