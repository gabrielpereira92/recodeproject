package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Departament;
import com.project.professorallocation.model.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {
	
	@Autowired
	ProfessorService professorService;
	
	@Test
	public void initSaveProfessorTest() {
		Departament departament = new Departament();
		departament.setId(5L);
		
		Professor professor = new Professor();
		professor.setName("Sérgio");
		professor.setCpf("901290105189");
		professor.setDepartament(departament);
		
		professorService.initSaveProfessor(professor);
		
	}


	@Test
	public void initUpdateProfessorTest() {
		
		Departament departament = new Departament();
		departament.setId(4L);

		Professor professor = new Professor();
		professor.setId(2L);
		professor.setCpf("1298219");
		professor.setName("Danilo");
		professor.setDepartament(departament);
		 
		professor = professorService.initUpdateProfessor(professor);
		System.out.println(professor);

	}

	@Test
	public void initFindAllTest() {
		List<Professor> list = professorService.initFindAll();

		System.out.println("Lista Professores");
		
		for (Professor professor : list) {
			System.out.println(professor);
			System.out.println("====================================================");
		}
	}

	@Test
	public void initFindByIdTest() {
	Professor professor = professorService.initFindById(2L);
	System.out.println(professor);
		

	}

	@Test
	public void initFindByNameTest() {
		String name = "telm";
		List<Professor> departaments = professorService.initFindByName(name);

		for (Professor professor : departaments) {
			System.out.println(professor);
		}
	}

	@Test
	public void initDeleteByIDTest() {
		professorService.initDeleteByID(2L);

	}

	@Test
	public void initDeleteAll() {
		professorService.initDeleteAll();
	}


	
	
	

}
