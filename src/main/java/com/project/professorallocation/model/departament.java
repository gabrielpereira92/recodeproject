package com.project.professorallocation.model;

public class Departament {

	private Long id;
	private String name;

	public Departament() {
		super();
	}

	public Departament(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
