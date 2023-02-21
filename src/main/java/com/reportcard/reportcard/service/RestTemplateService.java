package com.reportcard.reportcard.service;

import org.springframework.http.ResponseEntity;

import com.reportcard.reportcard.entity.Student;

public interface RestTemplateService
{
	ResponseEntity<String> getStudents();
	ResponseEntity<Student> addStudent(Student student);
}