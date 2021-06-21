package com.veer.studentdb.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veer.studentdb.entity.Student;
import com.veer.studentdb.repository.StudentRepository;



@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	// getting all Student record by using the method findaAll() of CrudRepository
	public List<Student> getAllStudent() {
		List<Student> student = new ArrayList<Student>();
		studentRepository.findAll().forEach(students1 -> student.add(students1));
		return student;
	}

	// getting a specific Student record by using the method findById() of CrudRepository
	public Student getStudentById(Integer s_id) {
		return studentRepository.findById(s_id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(Integer s_id) {
		studentRepository.deleteById(s_id);
	}

	// updating a record
	public void update(Student student, Integer s_id) {
		studentRepository.save(student);
	}

}
