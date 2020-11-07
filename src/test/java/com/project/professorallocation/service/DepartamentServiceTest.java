package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Departament;
import com.sun.el.stream.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartamentServiceTest {

	@Autowired
	DepartamentService departamentService;

	@Test
	public void initFindAllTest() {
		List<Departament> departaments = departamentService.initFindAll();

		for (Departament departament : departaments) {
			System.out.println(departament);

		}

	}

	@Test
	public void initFindByNameTest() {

		String name = "mate";
		List<Departament> departaments = departamentService.initFindByName(name);

		for (Departament departament : departaments) {
			System.out.println(departament);

		}

	}

	@Test
	public void initFindByIdTest() {

		Long id = 2L;
		Departament departament = departamentService.initFindById(id);
		System.out.println(departament);

	}

	@Test
	public void initSaveDepartamentTest() {
		Departament departament = new Departament();
		departament.setName("Física");

		departamentService.initSaveDepartament(departament);
	}

	@Test
	public void initUpdateDepartamentTest() {
		Departament departament = new Departament();
		departament.setId(2L);
		departament.setName("Geografia");

		departamentService.initUpdateDepartament(departament);
	}
	
	@Test
	public void initDeleteByIDTest() {
		Long id = 2L;
		departamentService.initDeleteByID(id);
	}
	@Test
	public void initDeleteAllTest() {
		departamentService.initDeleteAll();
	}

	
}
