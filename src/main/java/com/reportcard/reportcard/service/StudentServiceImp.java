package com.reportcard.reportcard.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reportcard.reportcard.entity.Grade;
import com.reportcard.reportcard.entity.Student;
import com.reportcard.reportcard.exception.GradeNotFoundException;
import com.reportcard.reportcard.exception.StudentNotFoundException;
import com.reportcard.reportcard.repository.StudentRepository;



@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

  
    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    @Override
    public Student getStudent(Long id)
    {
    	Optional<Student> student = studentRepository.findById(id);
    	if (student.isPresent())
    	{
    		return student.get();
    	}
    	else {
    		throw new StudentNotFoundException(id);
    	}
    }
    @Override
    public List<Student> getStudents() {
    	return (List<Student>)studentRepository.findAll();
    }
    @Override
    public void removeStudent(Long id) {
    	studentRepository.deleteById(id);
    }
    static Student unWrapStudent(Optional<Student> student , Long studentId) { 	    
    	if (student.isPresent()) return student.get();
    	else  throw new StudentNotFoundException(studentId);
        }
    	
}
