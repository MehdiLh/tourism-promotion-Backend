package com.auth.oauth2_resource_demo.dto;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Remove roles field
@Data
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
}