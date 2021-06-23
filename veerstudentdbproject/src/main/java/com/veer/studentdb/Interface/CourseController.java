package com.veer.studentdb.Interface;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.veer.studentdb.entity.Course;
import com.veer.studentdb.request.CourseRequest;

public interface CourseController {
	public List<Course> getCourses();

	public Course getCourseById(@PathVariable int c_id) throws Exception;

	public Course createCourse(@RequestBody CourseRequest courseRequest);

	public Course updateCourse(@RequestBody Course updcour, @PathVariable int c_id) throws Exception;

	public void deleteCourseById(@PathVariable int c_id) throws Exception;

	public void deleteAll();

}
