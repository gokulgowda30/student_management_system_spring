package com.springproject.student_management_system_spring.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springproject.student_management_system_spring.entity.User;
import com.springproject.student_management_system_spring.repository.UserRepository;

@Configuration
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        Set<String> roles = user.getRoles();
        return org.springframework.security.core.userdetails.User.builder()
                   .username(user.getUsername())
                   .password(user.getPassword())
                   .authorities(roles.stream()
                                     .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                                     .collect(Collectors.toList()))
                   .build();
    }
}
