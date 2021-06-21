package com.veer.studentdb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "s_id")
	private Integer s_id;
	private String s_fname;
	private String s_lname;
	private String s_gender;
	private String s_place;
	
	
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

	public String getS_gender() {
		return s_gender;
	}

	public void setS_gender(String s_gender) {
		this.s_gender = s_gender;
	}

	public String getS_place() {
		return s_place;
	}

	public void setS_place(String s_place) {
		this.s_place = s_place;
	}

}
