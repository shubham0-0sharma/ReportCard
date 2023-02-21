package com.reportcard.reportcard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reportcard.reportcard.entity.Student;
import com.reportcard.reportcard.service.RestTemplateService;
import com.reportcard.reportcard.service.RestTemplateServiceImp;

@RestController
@RequestMapping("/template")
public class RestTemplateController {
	@Autowired
	private RestTemplateServiceImp restTemplateServiceImp ;
	
	@GetMapping("/student/all")
	public ResponseEntity<String> getStudent()
	{
		return restTemplateServiceImp.getStudents();
	}
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody  Student student)
	{
		return restTemplateServiceImp.addStudent(student);
	}
}
