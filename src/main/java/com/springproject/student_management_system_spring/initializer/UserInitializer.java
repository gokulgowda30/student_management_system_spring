package com.springproject.student_management_system_spring.initializer;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springproject.student_management_system_spring.entity.User;
import com.springproject.student_management_system_spring.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class UserInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void addUser() {
        // Ensure you don't add duplicate users or handle logic to check if user already exists
        if (userRepository.findByUsername("admin") == null) {
            String username = "admin";
            String rawPassword = "admin123";
            String encodedPassword = passwordEncoder.encode(rawPassword);

            User user = new User();
            user.setUsername(username);
            user.setPassword(encodedPassword);
            user.setRoles(Set.of("USER")); // You can adjust roles as needed

            userRepository.save(user);
        }
    }
}
