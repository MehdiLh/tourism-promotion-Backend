package com.auth.oauth2_resource_demo.controller;

import com.auth.oauth2_resource_demo.models.User;
import com.auth.oauth2_resource_demo.repository.UserRepository;
import com.auth.oauth2_resource_demo.dto.UserBasicDTO;
import com.auth.oauth2_resource_demo.dto.RegistrationRequest;
import com.auth.oauth2_resource_demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/register")
    public ResponseEntity<UserBasicDTO> registerUser(@RequestBody @Valid RegistrationRequest dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }
    
}