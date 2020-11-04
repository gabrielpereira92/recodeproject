package com.project.professorallocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Departament;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartamentRepositoryTest {

	@Autowired
	private DepartamentRepository departamentRepository;

	@Test
	public void initSaveDepartament() {

		Departament departament = new Departament();
		departament.setId(null);
		departament.setName("Matemática");

		
		departament = departamentRepository.save(departament);

		System.out.println(departament);

	}

	@Test
	public void initUpdateDepartament() {

		Departament departament = new Departament();
		departament.setId(2L);
		departament.setName("Matemática II");

		departament = departamentRepository.save(departament);

		System.out.println(departament);

	}

	@Test
	public void initFindAll() {
		List<Departament> list = departamentRepository.findAll();

		System.out.println("Lista Departamentos");
		for (Departament departament : list) {
			System.out.println(departament);
			System.out.println("====================================================");
		
		}

	}

	@Test
	public void initFindById() {
		Optional<Departament> optionalDepartament = departamentRepository.findById(2L);
		Departament departament = optionalDepartament.orElse(null);

		System.out.println(departament);

	}

	@Test
	public void initDeleteByID() {
		departamentRepository.deleteById(4L);

	}

	@Test
	public void initDeleteAll() {
		departamentRepository.deleteAll();
	}

}