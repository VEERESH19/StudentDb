package com.veer.studentdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veer.studentdb.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
