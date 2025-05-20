package com.Student.crud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sgroup")
    private String sgroup;

    @Column(name = "course")
    private String course;

    @Column(name = "age")
    private Integer age;

    // Constructor
    public Student(Long id, String name, String sgroup, String course, Integer age) {
        this.id = id;
        this.name = name;
        this.sgroup = sgroup;
        this.course = course;
        this.age = age;
    }

public Student(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSgroup() {
        return sgroup;
    }

    public void setSgroup(String sgroup) {
        this.sgroup = sgroup;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}