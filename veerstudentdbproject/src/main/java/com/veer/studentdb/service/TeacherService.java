package com.veer.studentdb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veer.studentdb.entity.Teacher;
import com.veer.studentdb.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	// getting all Teacher record by using the method findaAll() of CrudRepository
	public List<Teacher> getAllTeacher() {
		List<Teacher> teacher = new ArrayList<Teacher>();
		teacherRepository.findAll().forEach(teacher1 -> teacher.add(teacher1));
		return teacher;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Teacher getTeacherById(Integer t_id) {
		return teacherRepository.findById(t_id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(Integer t_id) {
		teacherRepository.deleteById(t_id);
	}

	// updating a record
	public void update(Teacher teacher, Integer t_id) {
		teacherRepository.save(teacher);
	}

}
