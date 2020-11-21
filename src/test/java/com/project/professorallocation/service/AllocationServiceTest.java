package com.project.professorallocation.service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.model.Course;
import com.project.professorallocation.model.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationServiceTest {

	@Autowired
	AllocationService allocationService;

	@Test
	public void initSaveAllocationTest() {
		Professor professor = new Professor();
		professor.setId(2L);

		Course course = new Course();
		course.setId(2L);

		Allocation allocation = new Allocation();
		allocation.setDay(DayOfWeek.MONDAY);
		allocation.setStart(Time.valueOf("01:00:00"));
		allocation.setEnd(Time.valueOf("02:00:00"));
		allocation.setCourse(course);
		allocation.setProfessor(professor);

		allocationService.initSaveAllocation(allocation);

	}

	@Test
	public void initUpdateProfessorTest() {

		Professor professor = new Professor();
		professor.setId(2L);

		Course course = new Course();
		course.setId(2L);

		Allocation allocation = new Allocation();
		allocation.setId(2L);
		allocation.setDay(DayOfWeek.WEDNESDAY);
		allocation.setStart(Time.valueOf("06:00:00"));
		allocation.setEnd(Time.valueOf("08:00:00"));
		allocation.setCourse(course);
		allocation.setProfessor(professor);

		allocationService.initUpdateAllocation(allocation);

	}

	@Test
	public void initFindAllTest() {
		List<Allocation> list = allocationService.initFindAll();

		System.out.println("Lista Professores");

		for (Allocation allocation : list) {
			System.out.println(allocation);
			System.out.println("====================================================");
		}
	}

	@Test
	public void initFindByIdTest() {
		Allocation allocation = allocationService.initFindById(2L);
		System.out.println(allocation);

	}
	
	@Test
	public void initFindByProfessor() {
		Long id = 2L;
		
		List<Allocation> allocations = allocationService.initFindByProfessor(id);
		
		allocations.forEach(System.out::println);
		
	}
	
	@Test
	public void initFindByCourseTest() {
		Long id = 2L;
		List<Allocation> allocations = allocationService.initFindByCourse(id);
		allocations.forEach(System.out::println);
				
	}

	@Test
	public void initDeleteByIDTest() {
		allocationService.initDeleteByID(2L);

	}

	@Test
	public void initDeleteAll() {
		allocationService.initDeleteAll();
	}
}
