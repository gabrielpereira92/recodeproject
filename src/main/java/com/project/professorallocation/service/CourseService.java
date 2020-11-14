package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Course;
import com.project.professorallocation.repository.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	
	
	// Método que retorna toda a lista de courseos.
	public List<Course> initFindAll() {
		return courseRepository.findAll();

	}
	
	// Método que retorna o courseo por ID
	public Course initFindById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	// Método que retorna Courseo por nome
	public List<Course> initFindByName(String name) {
		return courseRepository.findByNameContainingIgnoreCase(name);

	}
	// Método que salva curso no banco
	public Course initSaveCourse(Course course) {
		course.setId(null);
		return courseRepository.save(course);
	}
	
	// Método que atualiza no banco
	public Course initUpdateCourse(Course course) {
		return courseRepository.save(course);

	}
	// Método que deleta por id
	public void initDeleteByID(Long id) {
		courseRepository.deleteById(id);
	}
	
	// Método que deleta todos os cursos
	public void initDeleteAll() {
		courseRepository.deleteAll();
	}

	

}





