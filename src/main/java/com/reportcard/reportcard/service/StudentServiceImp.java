package com.reportcard.reportcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reportcard.reportcard.entity.Student;
import com.reportcard.reportcard.repository.StudentRepository;



@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

  
    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
}
