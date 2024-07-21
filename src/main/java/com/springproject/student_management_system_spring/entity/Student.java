package com.springproject.student_management_system_spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

      @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false) //for custom name and not null
    private String fName;
    @Column(name = "last_name", nullable = false)
    private String lName;
    @Column(nullable = false , unique =  true)
    private String email;
    @Column(nullable = false , unique =  true)
    private String usn;
    @Column(nullable = false)
    private double cgpa;
}
