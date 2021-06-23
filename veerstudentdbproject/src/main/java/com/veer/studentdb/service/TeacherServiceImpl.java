package com.veer.studentdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veer.studentdb.Interface.TeacherService;
import com.veer.studentdb.entity.Teacher;
import com.veer.studentdb.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Optional<Teacher> getTeacherById(int courid) {
		return teacherRepository.findById(courid);
	}

	@Override
	public Teacher addNewTeacher(Teacher cour) {
		return teacherRepository.save(cour);
	}

	@Override
	public Teacher updateTeacher(Teacher cour) {
		return teacherRepository.save(cour);
	}

	@Override
	public void deleteTeacherById(int courid) {
		teacherRepository.deleteById(courid);
	}

	@Override
	public void deleteAllTeachers() {
		teacherRepository.deleteAll();
	}

}
