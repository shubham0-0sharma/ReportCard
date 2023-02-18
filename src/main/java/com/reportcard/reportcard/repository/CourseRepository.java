package com.reportcard.reportcard.repository;

import org.springframework.data.repository.CrudRepository;


import com.reportcard.reportcard.entity.Course;



public interface CourseRepository extends CrudRepository<Course, Long> {
    
}
