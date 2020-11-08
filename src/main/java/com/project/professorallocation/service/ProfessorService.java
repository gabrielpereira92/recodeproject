package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Professor;
import com.project.professorallocation.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	private ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}

	public Professor initSaveProfessor(Professor professor) {
		professor.setId(null);
		return professorRepository.save(professor);
	}
	
	public List<Professor> initFindAll(){
		return professorRepository.findAll();
		
	}
	
	public Professor initFindById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}
	
	public List<Professor> initFindByName(String name) {
		return professorRepository.findByNameContainingIgnoreCase(name);

	}
	
	public Professor initUpdateProfessor(Professor professor) {
		return professorRepository.save(professor);

	}
	
	public void initDeleteByID(Long id) {
		professorRepository.deleteById(id);
	}
	
	public void initDeleteAll() {
		professorRepository.deleteAll();
	}
	
}
