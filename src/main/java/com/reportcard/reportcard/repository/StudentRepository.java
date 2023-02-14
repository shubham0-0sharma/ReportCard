package com.reportcard.reportcard.repository;

import org.springframework.data.repository.CrudRepository;

import com.reportcard.reportcard.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>
{

	
	
}
