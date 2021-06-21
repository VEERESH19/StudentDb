package com.veer.studentdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veer.studentdb.entity.Student;



@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
