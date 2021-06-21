package com.veer.studentdb.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veer.studentdb.entity.Student;
import com.veer.studentdb.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/Student/all", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('Admin','User')")
	public List<Student> getStudents() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Students StudentService is invoked.");
		return studentService.getStudents();
	}

	@RequestMapping(value = "/Student/{s_id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public Student getStudentById(@PathVariable int s_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Student details by id is invoked.");

		Optional<Student> stu = studentService.getStudentById(s_id);
		if (!stu.isPresent())
			throw new Exception("Could not find Student with id- " + s_id);

		return stu.get();
	}

	@RequestMapping(value = "/Student/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('Admin')")
	public Student createStudent(@RequestBody Student newstu) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Student method is invoked.");
		return studentService.addNewStudent(newstu);
	}

	@RequestMapping(value = "/Student/update/{s_id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('Admin')")
	public Student updateStudent(@RequestBody Student updstu, @PathVariable int s_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Student details by id is invoked.");
		return studentService.updateStudent(updstu);
	}

	@RequestMapping(value = "/Student/delete/{s_id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteStudentById(@PathVariable int s_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Student by id is invoked.");

		Optional<Student> stu = studentService.getStudentById(s_id);
		if (!stu.isPresent())
			throw new Exception("Could not find Student with id- " + s_id);

		studentService.deleteStudentById(s_id);
	}

	@RequestMapping(value = "/Student/deleteall", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Students is invoked.");
		studentService.deleteAllStudents();
	}

}
