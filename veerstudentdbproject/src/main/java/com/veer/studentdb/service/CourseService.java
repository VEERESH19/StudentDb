package com.veer.studentdb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veer.studentdb.entity.Course;
import com.veer.studentdb.repository.CourseRepository;


@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	// getting all Course record by using the method findaAll() of CrudRepository
	public List<Course> getAllCourse() {
		List<Course> course = new ArrayList<Course>();
		courseRepository.findAll().forEach(course1 -> course.add(course1));
		return course;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Course getCourseById(Integer c_id) {
		return courseRepository.findById(c_id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Course course) {
		courseRepository.save(course);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(Integer c_id) {
		courseRepository.deleteById(c_id);
	}

	// updating a record
	public void update(Course course, Integer c_id) {
		courseRepository.save(course);
	}

}
