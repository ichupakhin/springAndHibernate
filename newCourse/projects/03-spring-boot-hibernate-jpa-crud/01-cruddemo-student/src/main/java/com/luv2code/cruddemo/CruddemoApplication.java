package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Duck");
		for(Student s: theStudents)
		{
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for(Student s: theStudents)
		{
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new studen object");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		System.out.println("Saved the student with id: " + theId);

		System.out.println("Retriving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student: " + myStudent);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Ceating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "pauldoe@luv2code.com");
		System.out.println("Saving Studen...");
		studentDAO.save(tempStudent);
		System.out.println("Saved student: Generated id: " + tempStudent.getId());
	}


}
