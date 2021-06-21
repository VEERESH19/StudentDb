package com.veer.studentdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.veer.studentdb.entity.Student;
import com.veer.studentdb.service.StudentService;

@RestController
public class StudentController {

	// StudentService class
	@Autowired
	StudentService studentService;

	// creating a get mapping that retrieves all the student detail from the
	// database
	@GetMapping("/getstudent")
	@PreAuthorize("hasRole('User')")
	private List<Student> getAllstudent() {
		return studentService.getAllStudent();
	}

	// creating a get mapping that retrieves the detail of a specific Student
	@GetMapping("/getStudent/{s_id}")
	@PreAuthorize("hasRole('Admin')")
	private Student getStudent(@PathVariable("s_id") Integer s_id) {
		return studentService.getStudentById(s_id);
	}

	// creating a delete mapping that deletes a specified Student
	@DeleteMapping("/deleteStudent/{s_id}")
	private void deleteStudent(@PathVariable("s_id") Integer s_id) {
		studentService.delete(s_id);
	}

	// creating post mapping that post the Student detail in the database
	@PostMapping("/postStudent")
	private Integer saveBook(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student.getS_id();
	}

	// creating put mapping that updates the Student detail
	@PutMapping("/student")
	private Student update(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student;
	}
}
