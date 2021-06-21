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
import com.veer.studentdb.entity.Course;
import com.veer.studentdb.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/Course/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public List<Course> getCourses() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Courses courseService is invoked.");
		return courseService.getCourses();
	}

	@RequestMapping(value = "/Course/{c_id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public Course getCourseById(@PathVariable int c_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Course details by id is invoked.");

		Optional<Course> cour = courseService.getCourseById(c_id);
		if (!cour.isPresent())
			throw new Exception("Could not find Course with id- " + c_id);

		return cour.get();
	}

	@RequestMapping(value = "/Course/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('Admin','User')")
	public Course createCourse(@RequestBody Course newcour) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Course method is invoked.");
		return courseService.addNewCourse(newcour);
	}

	@RequestMapping(value = "/Course/update/{c_id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('Admin')")
	public Course updateCourse(@RequestBody Course updcour, @PathVariable int c_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Course details by id is invoked.");
		return courseService.updateCourse(updcour);
	}

	@RequestMapping(value = "/Course/delete/{c_id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteCourseById(@PathVariable int c_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Course by id is invoked.");

		Optional<Course> cour = courseService.getCourseById(c_id);
		if (!cour.isPresent())
			throw new Exception("Could not find Course with id- " + c_id);

		courseService.deleteCourseById(c_id);
	}

	@RequestMapping(value = "/Course/deleteall", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Courses is invoked.");
		courseService.deleteAllCourses();
	}
}
