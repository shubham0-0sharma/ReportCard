package com.reportcard.reportcard.service;



import java.util.List;

import com.reportcard.reportcard.entity.Student;

public interface StudentService {
    
    Student saveStudent(Student student);
    Student getStudent(Long id);
    List<Student> getStudents();
    void removeStudent(Long id);

}
