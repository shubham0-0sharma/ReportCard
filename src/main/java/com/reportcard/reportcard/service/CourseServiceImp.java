package com.reportcard.reportcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reportcard.reportcard.entity.Course;
import com.reportcard.reportcard.entity.Grade;
import com.reportcard.reportcard.exception.CourseNotFoundException;
import com.reportcard.reportcard.exception.GradeNotFoundException;
import com.reportcard.reportcard.repository.CourseRepository;

@Service
public class CourseServiceImp implements CourseService{
	@Autowired
	CourseRepository courseRepository;
	@Override
    public Course saveCourse(Course course)
    {
    	return courseRepository.save(course);
    }
    
    @Override
    public Course getCourse(Long courseId) {
    	Optional<Course> course = courseRepository.findById(courseId);
    	if(course.isPresent())
    	return course.get();
    	else {
    		throw new CourseNotFoundException(courseId);
    	}
    }	
    @Override
    public List<Course> getCourses() {
    
    	return (List<Course>)courseRepository.findAll();
    }	
    
    @Override
    public void deleteCourse(Long courseId) {
    	courseRepository.deleteById(courseId);
    }
    static Course unWrapStudent(Optional<Course> course , Long courseId) { 	    
    	if (course.isPresent()) return course.get();
    	else  throw new CourseNotFoundException( courseId);
        }
    	
}

	