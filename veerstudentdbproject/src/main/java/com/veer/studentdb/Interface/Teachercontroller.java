package com.veer.studentdb.Interface;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.veer.studentdb.entity.Teacher;

public interface Teachercontroller {

	public List<Teacher> getTeachers();

	public Teacher getTeacherById(@PathVariable int t_id) throws Exception;

	public Teacher createTeacher(@RequestBody Teacher newteach);

	public Teacher updateTeacher(@RequestBody Teacher updteach, @PathVariable int t_id) throws Exception;

	public void deleteTeacherById(@PathVariable int t_id) throws Exception;

	public void deleteAll();

}
