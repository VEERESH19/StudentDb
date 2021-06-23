package com.veer.studentdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veer.studentdb.Interface.CourseService;
import com.veer.studentdb.entity.Course;
import com.veer.studentdb.repository.CourseRepository;
import com.veer.studentdb.request.CourseRequest;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	public Course addNewCourse(CourseRequest courseRequest) throws Exception {
		System.out.println("add Coin Service class");
		Course course = new Course();
		course.setC_name(courseRequest.getC_name());
		course.setC_fees(courseRequest.getC_fees());
		course.setC_duration(courseRequest.getC_duration());
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getCourses() {

		return courseRepository.findAll();
	}

	@Override
	public Optional<Course> getCourseById(int courid) {
		return courseRepository.findById(courid);
	}

	@Override
	public Course updateCourse(Course cour) {
		return courseRepository.save(cour);
	}

	@Override
	public void deleteCourseById(int courid) {
		courseRepository.deleteById(courid);
	}

	@Override
	public void deleteAllCourses() {
		courseRepository.deleteAll();
	}

}
