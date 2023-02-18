package com.reportcard.reportcard.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
@Getter
@Setter

@NoArgsConstructor
@Entity
@Table(name = "grade")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long id ;
	@Column(name = "score")
    private String score;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "student_id",referencedColumnName = "id")
	private Student student;

	@ManyToOne(optional = false)
	@JoinColumn(name="course_id", referencedColumnName = "id")
	private Course course;
	}

