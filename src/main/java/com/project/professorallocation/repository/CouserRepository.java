package com.project.professorallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professorallocation.model.Course;

@Repository
public interface CouserRepository extends JpaRepository<Course, Long> {

	List<Course> findByNameContainingIgnoreCase(String name);
}
