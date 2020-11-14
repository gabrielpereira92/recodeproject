package com.project.professorallocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Course;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseServiceTest {
	
	@Autowired
	CourseService courseService;
	
	@Test
	public void initSaveCourseTest() {
		Course course = new Course();
		
		course.setName("Curso 3");
		
		courseService.initSaveCourse(course);
		
	}
	
	@Test
	public void initFindAllTest() {
		List<Course> courses = courseService.initFindAll();

		for (Course course : courses) {
			System.out.println(course);

		}

	}

	@Test
	public void initFindByNameTest() {

		String name = "urso";
		List<Course> courses = courseService.initFindByName(name);

		for (Course course : courses) {
			System.out.println(course);

		}

	}

	@Test
	public void initFindByIdTest() {

		Long id = 2L;
		Course course = courseService.initFindById(id);
		System.out.println(course);

	}


	@Test
	public void initUpdateCourseTest() {
		Course course = new Course();
		course.setId(2L);
		course.setName("Curso de Pedagogia");

		courseService.initUpdateCourse(course);
	}
	
	@Test
	public void initDeleteByIDTest() {
		Long id = 1L;
		courseService.initDeleteByID(id);
	}
	@Test
	public void initDeleteAllTest() {
		courseService.initDeleteAll();
	}
	

}
