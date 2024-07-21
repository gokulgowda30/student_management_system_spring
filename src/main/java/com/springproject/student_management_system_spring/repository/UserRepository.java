package com.springproject.student_management_system_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.student_management_system_spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
