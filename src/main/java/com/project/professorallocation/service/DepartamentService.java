package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Departament;
import com.project.professorallocation.repository.DepartamentRepository;

@Service
public class DepartamentService {

	private DepartamentRepository departamentRepository;

	public DepartamentService(DepartamentRepository departamentRepository) {
		super();
		this.departamentRepository = departamentRepository;
	}

	// Método que retorna toda a lista de departamentos.
	public List<Departament> initFindAll() {
		return departamentRepository.findAll();

	}
	
	// Método que retorna o departamento por ID
	public Departament initFindById(Long id) {
		return departamentRepository.findById(id).orElse(null);
	}

	// Método que retorna Departamento por nome
	public List<Departament> initFindByName(String name) {
		return departamentRepository.findByNameContainingIgnoreCase(name);

	}
	// Método que salva departamento no banco
	public Departament initSaveDepartament(Departament departament) {
		departament.setId(null);
		return departamentRepository.save(departament);
	}
	
	// Método que atualiza departamento no banco
	public Departament initUpdateDepartament(Departament departament) {
		return departamentRepository.save(departament);

	}
	// Método que deleta departamento por id
	public void initDeleteByID(Long id) {
		departamentRepository.deleteById(id);
	}
	
	// Método que deleta todos os departamentos
	public void initDeleteAll() {
		departamentRepository.deleteAll();
	}


}
