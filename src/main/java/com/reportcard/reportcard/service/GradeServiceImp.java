package com.reportcard.reportcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reportcard.reportcard.entity.Course;
import com.reportcard.reportcard.entity.Grade;
import com.reportcard.reportcard.entity.Student;
import com.reportcard.reportcard.exception.CourseNotFoundException;
import com.reportcard.reportcard.exception.GradeNotFoundException;
import com.reportcard.reportcard.repository.CourseRepository;
import com.reportcard.reportcard.repository.GradeRepository;
import com.reportcard.reportcard.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImp implements GradeService {

	private StudentRepository studentRepository;
	private CourseRepository courseRepository;
	
	private GradeRepository gradeRepository;
	
	@Override
	public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
		Optional<Student> student = studentRepository.findById(studentId);
		Optional<Course>  course = courseRepository.findById(courseId);
		if (student.isPresent() && course.isPresent()) {
		grade.setStudent(student.get());
		grade.setCourse(course.get());}
		else {
			throw new CourseNotFoundException(courseId);
		}
		return gradeRepository.save(grade);
		
	}
	
	@Override
	public Grade updateGrade(String score, Long studentId, Long courseId) {
		Optional< Grade>  grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
		if (grade.isPresent())
		
		{grade.get().setScore(score);
		return gradeRepository.save(grade.get());
		}
		else {
			throw new GradeNotFoundException(studentId, courseId);
		}
	}
	@Override
	public Grade getGrade(Long studentId, Long courseId){
		Optional< Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
		if (grade.isPresent())
		return grade.get();
		else {
			throw new GradeNotFoundException(studentId, courseId);
		}
    
     }
    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }
    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

	}
