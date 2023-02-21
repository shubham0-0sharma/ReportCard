package com.reportcard.reportcard.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reportcard.reportcard.entity.Student;

@Service
public class RestTemplateServiceImp implements RestTemplateService {

	@Autowired
	RestTemplate restTemplate;
	
	private static final String get_student_url = "http://localhost:8080/student/all";
	private static final String add_student_url = "http://localhost:8080/student";
	
	@Override
	public ResponseEntity<String> getStudents()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>( headers);
		ResponseEntity<String> response =  restTemplate.exchange(get_student_url,HttpMethod.GET ,entity, String.class);
		 return response;
		
	}
	
	@Override
	public ResponseEntity<Student> addStudent(Student student) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList( MediaType.APPLICATION_JSON));
		HttpEntity<Student> entity  = new HttpEntity<>(student,headers);
		ResponseEntity<Student> response = 
		restTemplate.exchange(add_student_url, HttpMethod.POST,entity,Student.class);
		return response;
		
		
		
		
	}
}
