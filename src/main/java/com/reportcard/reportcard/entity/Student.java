package com.reportcard.reportcard.entity;

import java.time.LocalDate;

public class Student {
    private Long id;
    private String name;
    private LocalDate birthDate;

    public Student(Long id, String name , LocalDate birthDate){
        this.id = id;
        this.name = name ;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setId(Long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }

    public Student() {
    }

}
