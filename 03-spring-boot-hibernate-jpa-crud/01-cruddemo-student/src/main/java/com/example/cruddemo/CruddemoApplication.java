package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
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
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = new ArrayList<>();
		students = studentDAO.findAll();

		// display a list of students
		System.out.println("All Students: ");
		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student student = new Student("Josely", "Vieira", "jojo@gmail.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Id: " + student.getId());
		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + student.getId());
		studentDAO.findById(student.getId());

		// display student
		System.out.println("Student: " + student.toString());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students objects
		System.out.println("Creating students...");
		Student student1 = new Student("Maria", "Brown", "maria@gmail.com");
		Student student2 = new Student("Bob", "Green", "bob@gmail.com");
		Student student3 = new Student("Alex", "Red", "alex@gmail.com");

		// save the student object
		System.out.println("Saving student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating student...");
		Student student = new Student("Rodrigo", "Alves", "rodrigo@gmail.com");

		// save the student object
		System.out.println("Saving student...");
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student: " + student.toString());
	}

}
