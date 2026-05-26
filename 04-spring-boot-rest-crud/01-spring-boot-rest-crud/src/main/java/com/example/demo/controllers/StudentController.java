package com.example.demo.controllers;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Rodrigo", "Alexandre"));
        students.add(new Student("Josely", "Vieira"));
        students.add(new Student("Mary", "Brown"));
        students.add(new Student("Alex", "Blue"));

        return students;
    }

}
