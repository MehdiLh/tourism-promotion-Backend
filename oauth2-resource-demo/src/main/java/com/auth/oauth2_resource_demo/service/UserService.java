package com.auth.oauth2_resource_demo.service;

import com.auth.oauth2_resource_demo.dto.RegistrationRequest;
import com.auth.oauth2_resource_demo.dto.UserBasicDTO;
import com.auth.oauth2_resource_demo.mappers.UserMapper;
import com.auth.oauth2_resource_demo.models.Role;
import com.auth.oauth2_resource_demo.models.User;
import com.auth.oauth2_resource_demo.repository.RoleRepository;
import com.auth.oauth2_resource_demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserBasicDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toBasicDTO)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public UserBasicDTO createUser(RegistrationRequest dto) {
        Role userRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Default user role not configured"));

        User user = User.builder()
            .username(dto.getUsername())
            .email(dto.getEmail())
            .password(passwordEncoder.encode(dto.getPassword()))
            .roles(Set.of(userRole)) // Enforce default role
            .build();

        return UserMapper.toBasicDTO(userRepository.save(user));
    }

   
}