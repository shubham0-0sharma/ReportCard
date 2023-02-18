package com.reportcard.reportcard.service;

import java.util.List;

import com.reportcard.reportcard.entity.Course;

public interface CourseService {
 
	Course saveCourse(Course course);
	Course getCourse(Long courseId);
	List<Course> getCourses();
	void deleteCourse(Long courseId);
	
}
