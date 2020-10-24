package com.project.professorallocation.model;

import java.sql.Time;

public class allocation {

	private Long id;
	private String day;
	private Time end;
	private Time start;

	public allocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public allocation(Long id, String day, Time end, Time start) {
		super();
		this.id = id;
		this.day = day;
		this.end = end;
		this.start = start;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

}
