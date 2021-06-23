package com.veer.studentdb.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.veer.studentdb.Interface.TeacherService;
import com.veer.studentdb.entity.Teacher;

@RestController
public class TeacherControllerImpl {

	@Autowired
	TeacherService teacherService;

	@RequestMapping(value = "/Teacher/all", method = RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public List<Teacher> getTeachers() {
		System.out.println(this.getClass().getSimpleName() + " - Get all Teachers TeacherService is invoked.");
		return teacherService.getTeachers();
	}

	@RequestMapping(value = "/Teacher/{t_id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('Admin')")
	public Teacher getTeacherById(@PathVariable int t_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Get Teacher details by id is invoked.");

		Optional<Teacher> teach = teacherService.getTeacherById(t_id);
		if (!teach.isPresent())
			throw new Exception("Could not find Teacher with id- " + t_id);

		return teach.get();
	}

	@RequestMapping(value = "/Teacher/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('Admin')")
	public Teacher createTeacher(@RequestBody Teacher newteach) {
		System.out.println(this.getClass().getSimpleName() + " - Create new Teacher method is invoked.");
		return teacherService.addNewTeacher(newteach);
	}

	@RequestMapping(value = "/Teacher/update/{t_id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('Admin')")
	public Teacher updateTeacher(@RequestBody Teacher updteach, @PathVariable int t_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update Teacher details by id is invoked.");

		Optional<Teacher> cour = teacherService.getTeacherById(t_id);
		if (!cour.isPresent())
			throw new Exception("Could not find employee with id- " + t_id);

		if (updteach.getT_name() == null || updteach.getT_name().isEmpty())
			updteach.setT_name(cour.get().getT_name());
		if (updteach.getT_age() == 0)
			updteach.setT_age(cour.get().getT_age());

		updteach.setT_id(t_id);

		return teacherService.updateTeacher(updteach);
	}

	@RequestMapping(value = "/Teacher/delete/{t_id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteTeacherById(@PathVariable int t_id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete Teacher by id is invoked.");

		Optional<Teacher> teach = teacherService.getTeacherById(t_id);
		if (!teach.isPresent())
			throw new Exception("Could not find Teacher with id- " + t_id);

		teacherService.deleteTeacherById(t_id);
	}

	@RequestMapping(value = "/Teacher/deleteall", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('Admin')")
	public void deleteAll() {
		System.out.println(this.getClass().getSimpleName() + " - Delete all Teachers is invoked.");
		teacherService.deleteAllTeachers();
	}

}
