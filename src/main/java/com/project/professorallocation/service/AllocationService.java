package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.model.Course;
import com.project.professorallocation.model.Professor;
import com.project.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private AllocationRepository allocationRepository;
	private ProfessorService professorService;
	private CourseService courseService;

	public AllocationService(AllocationRepository allocationRepository, ProfessorService professorService,
			CourseService courseService) {
		super();
		this.allocationRepository = allocationRepository;
		this.professorService = professorService;
		this.courseService = courseService;
	}

	public Allocation initSaveAllocation(Allocation allocation) {
		allocation.setId(null);
		return internalSave(allocation);
	}

	// Método que busca em por professores em Allocation
	public List<Allocation> initFindByProfessor(Long id) {
		Professor professor = new Professor();
		professor.setId(id);
		return allocationRepository.findByProfessor(professor);
	}

	// Método que busca em por cursos em Allocation
	public List<Allocation> initFindByCourse(Long id) {
		Course course = new Course();
		course.setId(id);
		return allocationRepository.findByCourse(course);
	}

	public List<Allocation> initFindAll() {
		return allocationRepository.findAll();
	}

	public Allocation initFindById(Long id) {
		return allocationRepository.findById(id).orElse(null);
	}

	public Allocation initUpdateAllocation(Allocation allocation) {
		Long id = allocation.getId();
		Allocation findedAllocation = allocationRepository.findById(id).orElse(null);
		if (findedAllocation == null) {
			return null;
		}
		return internalSave(allocation);

	}
	
	private Allocation internalSave(Allocation allocation) {
		
		try { 
			if(!hasCollision(allocation)) {
				allocation = allocationRepository.save(allocation);
				if (allocation != null) {
					Professor professor = allocation.getProfessor();
					professor = professorService.initFindById(professor.getId());
					allocation.setProfessor(professor);
					
					Course course = allocation.getCourse();
					course = courseService.initFindById(course.getId());
					allocation.setCourse(course);
				}
				return allocation;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private boolean hasCollision(Allocation newAllocation) {
		boolean hasCollision = false;
		
		List<Allocation> currentAllocations = allocationRepository.findByProfessor(newAllocation.getProfessor());
		
		for (Allocation currentAllocation : currentAllocations) {
			hasCollision = hasCollision(currentAllocation, newAllocation);
			if(hasCollision) {
				break;
			}
		}
		return hasCollision;
	}
	
	private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		return currentAllocation.getDay() == newAllocation.getDay() 
		&& currentAllocation.getStart().compareTo(newAllocation.getEnd()) < 0
		&& newAllocation.getStart().compareTo(currentAllocation.getEnd()) < 0;
		
	}
	

	public void initDeleteByID(Long id) {
		allocationRepository.deleteById(id);
	}

	public void initDeleteAll() {
		allocationRepository.deleteAll();
	}

}
