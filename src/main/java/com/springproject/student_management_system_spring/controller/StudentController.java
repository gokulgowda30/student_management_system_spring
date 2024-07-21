package com.springproject.student_management_system_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springproject.student_management_system_spring.entity.Student;
import com.springproject.student_management_system_spring.service.StudentService;


@Controller
public class StudentController {
    // A controller for student to handle requests
    private StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }


    //get all students
    @RequestMapping("/students")
     String getAllStudents(Model model){ // create a model  to send data betn view and controller
        model.addAttribute("students",service.getAllStudents());
        return "students"; // returns a students view which should be created inside templates
    }

    @RequestMapping("students/add")
    String addStudentForm(Model model){
        Student student = new Student(); // object to hold student data
        model.addAttribute("student",student);
        return "add-student";
    }

    @PostMapping("students")
    String addStudent(@ModelAttribute Student student){
        service.addStudent(student);
        return "redirect:/students";
    }

    @RequestMapping("students/remove/{id}")
    String deleteStudent(@PathVariable long id, Model model) throws Exception{
        service.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("students/update/{id}")
    String updateStudentForm(@PathVariable Long id, Model model) throws Exception{
       // Student student = new Student();
        model.addAttribute("student", service.getStudentById(id));
        return "update-student";
    }
    @PostMapping("students/{id}")
    String editStudent(@PathVariable Long id,@ModelAttribute Student student){
        Student existingStudent = service.getStudentById(id); // get existing student to update existing data

        existingStudent.setId(id);
        existingStudent.setFName(student.getFName());
        existingStudent.setLName(student.getLName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setUsn(student.getUsn());
        existingStudent.setCgpa(student.getCgpa());

        service.updateStudent(existingStudent); //fetch to  update the existing student
        return "redirect:/students";
    }

}
