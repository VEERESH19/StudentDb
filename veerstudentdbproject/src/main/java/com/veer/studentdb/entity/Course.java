package com.veer.studentdb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_id")
	private Integer c_id;
	private String c_name;
	private Integer c_fees;
	private String c_duration;

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public Integer getC_fees() {
		return c_fees;
	}

	public void setC_fees(Integer c_fees) {
		this.c_fees = c_fees;
	}

	public String getC_duration() {
		return c_duration;
	}

	public void setC_duration(String c_duration) {
		this.c_duration = c_duration;
	}

}
