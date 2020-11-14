package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	
	private AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}
	

	public Allocation initSaveAllocation(Allocation allocation) {
		allocation.setId(null);
		return allocationRepository.save(allocation);
	}
	
	public List<Allocation> initFindAll(){
		return allocationRepository.findAll();
		
	}
	
	public Allocation initFindById(Long id) {
		return allocationRepository.findById(id).orElse(null);
	}
	
		
	public Allocation initUpdateAllocation(Allocation allocation) {
		return allocationRepository.save(allocation);

	}
	
	public void initDeleteByID(Long id) {
		allocationRepository.deleteById(id);
	}
	
	public void initDeleteAll() {
		allocationRepository.deleteAll();
	}

}
