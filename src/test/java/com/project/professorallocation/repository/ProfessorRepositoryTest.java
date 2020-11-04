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
import com.project.professorallocation.model.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	private ProfessorRepository professorRepository;

	@Test
	public void initSaveProfessor() {

		Departament departament = new Departament();
		departament.setId(2L);

		Professor professor = new Professor();
		professor.setId(null);
		professor.setCpf("34562334712891");
		professor.setName("Natanael");
		professor.setDepartament(departament);

		professor = professorRepository.save(professor);

		System.out.println(professor);

	}

	@Test
	public void initUpdateProfessor() {

		Departament departament = new Departament();
		departament.setId(1L);

		Professor professor = new Professor();
		professor.setId(3L);
		professor.setCpf("345623347");
		professor.setName("Alarcon");
		professor.setDepartament(departament);

		professor = professorRepository.save(professor);

		System.out.println(professor);

	}

	@Test
	public void initFindAll() {
		List<Professor> list = professorRepository.findAll();

		System.out.println("Professores da escola");
		for (Professor professor : list) {
			System.out.println(professor);
			System.out.println("==================================================");

		}

	}

	@Test
	public void initFindById() {
		Optional<Professor> optionalProfessor = professorRepository.findById(2L);
		Professor professor = optionalProfessor.orElse(null);

		System.out.println(professor);

	}

	@Test
	public void initDeleteByID() {
		professorRepository.deleteById(4L);

	}

	@Test
	public void initDeleteAll() {
		professorRepository.deleteAll();
	}

}
