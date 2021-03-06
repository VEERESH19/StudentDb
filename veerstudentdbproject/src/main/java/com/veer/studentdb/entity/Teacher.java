package com.veer.studentdb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_id")
	private Integer t_id;

	private String t_name;
	private Integer t_age;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="c_id",referencedColumnName = "c_id")
	private Course course;

	public Teacher() {

	}

	public Teacher(Integer t_id, String t_name, Integer t_age) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_age = t_age;

	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public Integer getT_age() {
		return t_age;
	}

	public void setT_age(Integer t_age) {
		this.t_age = t_age;
	}

	@Override
	public String toString() {
		return "Teacher [t_id=" + t_id + ", t_name=" + t_name + ", t_age=" + t_age + "]";
	}

}
