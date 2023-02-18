package com.reportcard.reportcard.entity;



import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
    @NonNull
    @Column(name = "subject",nullable = false)
    private String subject;
    @NonNull
    @Column(name = "code",nullable = false)
    private String code;
    @NonNull
    @Column(name = "description")
    private String description;
    
   
    @ManyToOne()
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;
    
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Grade> grades;
    
}
