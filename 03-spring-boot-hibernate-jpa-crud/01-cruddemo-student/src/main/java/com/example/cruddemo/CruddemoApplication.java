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
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// quertForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student...");
		student.setFirstName("Rodrigo");

		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Update student: " + student);
	}

	private void quertForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = new ArrayList<>();
		students = studentDAO.findByLastName("Brown");

		// display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = new ArrayList<>();
		students = studentDAO.findAll();

		// display a list of students
		System.out.println("All Students: ");
		for (Student student : students) {
			System.out.println(student);
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
