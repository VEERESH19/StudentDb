package com.veer.studentdb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer s_id;

	private String s_fname;

	private String s_lname;

	private Integer s_age;

	private String s_gender;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>();

	public Student() {

	}

	public Student(String s_fname, String s_lname, Integer s_age, String s_gender) {

		this.s_fname = s_fname;
		this.s_lname = s_lname;
		this.s_age = s_age;
		this.s_gender = s_gender;

	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Integer getS_id() {
		return s_id;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public String getS_fname() {
		return s_fname;
	}

	public void setS_fname(String s_fname) {
		this.s_fname = s_fname;
	}

	public String getS_lname() {
		return s_lname;
	}

	public void setS_lname(String s_lname) {
		this.s_lname = s_lname;
	}

	public Integer getS_age() {
		return s_age;
	}

	public void setS_age(Integer s_age) {
		this.s_age = s_age;
	}

	public String getS_gender() {
		return s_gender;
	}

	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_fname=" + s_fname + ", s_lname=" + s_lname + ", s_age=" + s_age
				+ ", s_gender=" + s_gender + "]";
	}

}
