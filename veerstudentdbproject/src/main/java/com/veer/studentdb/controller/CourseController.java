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

import com.veer.studentdb.entity.Course;
import com.veer.studentdb.service.CourseService;


@RestController
public class CourseController {

	// CourseService class
	@Autowired
	CourseService courseService;

	// creating a get mapping that retrieves all the Course detail from the
	// database
	@GetMapping("/getCourse")
	@PreAuthorize("hasRole('Admin')")
	private List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}

	// creating a get mapping that retrieves the detail of a specific Course
	@GetMapping("/getCourse/{c_id}")
	private Course getCourse(@PathVariable("c_id") Integer c_id) {
		return courseService.getCourseById(c_id);
	}

	// creating a delete mapping that deletes a specified Course
	@DeleteMapping("/deleteCourse/{c_id}")
	private void deleteCourse(@PathVariable("c_id") Integer c_id) {
		courseService.delete(c_id);
	}

	// creating post mapping that post the Course detail in the database
	@PostMapping("/postCourse")
	private Integer saveCourse(@RequestBody Course course) {
		courseService.saveOrUpdate(course);
		return course.getC_id();
	}

	// creating put mapping that updates the Course detail
	@PutMapping("/course")
	private Course update(@RequestBody Course course) {
		courseService.saveOrUpdate(course);
		return course;
	}

}
