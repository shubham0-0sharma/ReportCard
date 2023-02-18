package com.reportcard.reportcard.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reportcard.reportcard.entity.Course;

import com.reportcard.reportcard.service.CourseServiceImp;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {
    private CourseServiceImp courseServiceImp;
	@PostMapping
		public ResponseEntity<Course> saveCourse(@RequestBody Course course)
		{
		
			return new ResponseEntity<>(courseServiceImp.saveCourse(course),HttpStatus.CREATED);
		}
	@GetMapping("/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable Long courseId)
	{
		return new ResponseEntity<>(courseServiceImp.getCourse(courseId), HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Course>> getCourses()
	{
		return new ResponseEntity<>(courseServiceImp.getCourses(), HttpStatus.OK);
		
	}
	@DeleteMapping("/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long courseId)
	{
		courseServiceImp.deleteCourse(courseId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
