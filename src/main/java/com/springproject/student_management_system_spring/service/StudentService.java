package com.springproject.student_management_system_spring.service;

import java.util.List;

import com.springproject.student_management_system_spring.entity.Student;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student addStudent(Student student);

    void deleteStudent(Long id);

    Student updateStudent(Student student);
}
