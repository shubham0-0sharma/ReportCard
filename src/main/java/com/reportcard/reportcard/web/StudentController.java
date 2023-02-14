package com.reportcard.reportcard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.reportcard.reportcard.entity.Student;
import com.reportcard.reportcard.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
        public ResponseEntity<Student> saveStudent(@RequestBody Student student){
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);

        
    }



}

