package com.veer.studentdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veer.studentdb.entity.Student;
import com.veer.studentdb.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	@Override
	public Optional<Student> getStudentById(int stuid) {
		return studentRepository.findById(stuid);
	}
	@Override
	public Student addNewStudent(Student stu) {
		return studentRepository.save(stu);
	}
	@Override
	public Student updateStudent(Student stu) {
		return studentRepository.save(stu);
	}
	@Override
	public void deleteStudentById(int stuid) {
		studentRepository.deleteById(stuid);
	}
	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}


}
