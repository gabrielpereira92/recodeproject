package com.project.professorallocation.repository;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.model.Course;
import com.project.professorallocation.model.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class AllocationRepositoryTest {

	@Autowired
	private AllocationRepository allocationRepository;

	@Test
	public void initSaveAllocation() {
		Professor professor = new Professor();
		professor.setId(1L);

		Course course = new Course();
		course.setId(1L);

		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setDay(DayOfWeek.FRIDAY);
		allocation.setStart(Time.valueOf("08:00:00"));
		allocation.setEnd(Time.valueOf("12:00:00"));

		allocation = allocationRepository.save(allocation);

		System.out.println(allocation);

	}

	@Test
	public void initUpdateAllocation() {
		Professor professor = new Professor();
		professor.setId(1L);

		Course course = new Course();
		course.setId(1L);

		Allocation allocation = new Allocation();
		allocation.setId(1L);
		allocation.setDay(DayOfWeek.FRIDAY);
		allocation.setStart(Time.valueOf("08:00:00"));
		allocation.setEnd(Time.valueOf("10:00:00"));

		allocation = allocationRepository.save(allocation);

		System.out.println(allocation);
	}

	@Test
	public void initFindAll() {
		List<Allocation> list = allocationRepository.findAll();

		System.out.println("Lista Cursos");
		for (Allocation allocation : list) {
			System.out.println(allocation);
			System.out.println("====================================================");

		}

	}

	@Test
	public void initFindById() {
		Optional<Allocation> optionalAllocation = allocationRepository.findById(2L);
		Allocation allocation = optionalAllocation.orElse(null);

		System.out.println(allocation);

	}

	@Test
	public void initDeleteByID() {
		allocationRepository.deleteById(2L);

	}

	@Test
	public void initDeleteAll() {
		allocationRepository.deleteAll();
	}

}