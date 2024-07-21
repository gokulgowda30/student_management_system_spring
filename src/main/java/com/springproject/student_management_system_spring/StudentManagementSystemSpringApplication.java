package com.springproject.student_management_system_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class StudentManagementSystemSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemSpringApplication.class, args);
	}

}
@Controller
 class LoginController {

	 @GetMapping("/login")
	    public String login(@RequestParam(value = "logout", required = false) String logout, Model model) {
	        if (logout != null) {
	            model.addAttribute("logoutMessage", "You have been logged out successfully.");
	        }
	        return "login"; // name of the Thymeleaf template
	    }
}