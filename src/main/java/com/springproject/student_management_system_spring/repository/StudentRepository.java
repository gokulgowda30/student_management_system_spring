package com.springproject.student_management_system_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.student_management_system_spring.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // <entity name , typeof primary key> // type of primary key cannot be primitive
}
