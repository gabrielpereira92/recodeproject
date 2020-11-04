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

import com.project.professorallocation.model.Course;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void initSaveCourse() {

		Course course = new Course();
		course.setId(null);
		course.setName("Curso 2");

		
		course = courseRepository.save(course);

		System.out.println(course);

	}

	@Test
	public void initUpdateCourse() {

		Course course = new Course();
		course.setId(2L);
		course.setName("Curso 3");

		course = courseRepository.save(course);

		System.out.println(course);

	}

	@Test
	public void initFindAll() {
		List<Course> list = courseRepository.findAll();

		System.out.println("Lista Cursos");
		for (Course course : list) {
			System.out.println(course);
			System.out.println("====================================================");
		
		}

	}

	@Test
	public void initFindById() {
		Optional<Course> optionalCourse = courseRepository.findById(2L);
		Course course = optionalCourse.orElse(null);

		System.out.println(course);

	}

	@Test
	public void initDeleteByID() {
		courseRepository.deleteById(2L);

	}

	@Test
	public void initDeleteAll() {
		courseRepository.deleteAll();
	}

}