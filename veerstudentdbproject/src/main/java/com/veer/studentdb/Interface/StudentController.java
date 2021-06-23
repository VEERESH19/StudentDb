package com.veer.studentdb.Interface;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.veer.studentdb.entity.Student;

public interface StudentController {

	public List<Student> getStudents();

	public Student getStudentById(@PathVariable int s_id) throws Exception;

	public Student createStudent(@RequestBody Student newstu);

	public Student updateStudent(@RequestBody Student updstu, @PathVariable int s_id) throws Exception;

	public void deleteStudentById(@PathVariable int s_id) throws Exception;

	public void deleteAll();

}
