package com.project.professorallocation.repository;

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
		departament.setId(1L);

		Professor professor = new Professor();
		professor.setId(null);
		professor.setCpf("345623346");
		professor.setName("Natanael");
		professor.setDepartament(departament);
		
		professor = professorRepository.save(professor);
		
		System.out.println(professor);
	}

}
