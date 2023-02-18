package com.reportcard.reportcard;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.reportcard.reportcard.exception.CourseNotFoundException;
import com.reportcard.reportcard.exception.ErrorResponse;
import com.reportcard.reportcard.exception.GradeNotFoundException;
import com.reportcard.reportcard.exception.StudentNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<Object> handleStudentNotFoundException (StudentNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
		
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleCourseNotFoundException (CourseNotFoundException ex){ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
	return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleGradeNotFoundException (GradeNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	
	}
	
}