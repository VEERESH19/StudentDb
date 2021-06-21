package com.veer.studentdb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.veer.studentdb.entity.Teacher;
import com.veer.studentdb.service.TeacherService;


@RestController
public class TeacherController {

	// TeacherService class
	@Autowired
	TeacherService teacherService;

	// creating a get mapping that retrieves all the Teacher detail from the
	// database
	@GetMapping("/teacher")
	private List<Teacher> getAllTeacher() {
		return teacherService.getAllTeacher();
	}

	// creating a get mapping that retrieves the detail of a specific Teacher
	@GetMapping("/getTeacher/{t_id}")
	private Teacher getTeacher(@PathVariable("t_id") Integer t_id) {
		return teacherService.getTeacherById(t_id);
	}

	// creating a delete mapping that deletes a specified Teacher
	@DeleteMapping("/deleteTeacher/{t_id}")
	private void deleteStudent(@PathVariable("t_id") Integer t_id) {
		teacherService.delete(t_id);
	}

	// creating post mapping that post the Teacher detail in the database
	@PostMapping("/postTeacher")
	private Integer saveBook(@RequestBody Teacher teacher) {
		teacherService.saveOrUpdate(teacher);
		return teacher.getT_id();
	}

	// creating put mapping that updates the Teacher detail
	@PutMapping("/teacher")
	private Teacher update(@RequestBody Teacher teacher) {
		teacherService.saveOrUpdate(teacher);
		return teacher;
	}

}
