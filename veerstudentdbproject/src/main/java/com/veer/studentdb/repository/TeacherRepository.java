package com.veer.studentdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veer.studentdb.entity.Teacher;


@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

}
