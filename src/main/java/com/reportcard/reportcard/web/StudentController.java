package com.reportcard.reportcard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.reportcard.reportcard.entity.Student;
import java.util.List;
import com.reportcard.reportcard.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;







@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.OK) ;
    } 

    @PostMapping()
        public ResponseEntity<Student> saveStudent(@RequestBody Student student){
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);

        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeStudent(@PathVariable Long id){
    	studentService.removeStudent(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
      
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){
    	return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
    }


}

