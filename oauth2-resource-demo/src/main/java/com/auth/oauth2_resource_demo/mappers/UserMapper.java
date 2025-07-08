package com.auth.oauth2_resource_demo.mappers;

import com.auth.oauth2_resource_demo.dto.RegistrationRequest;
import com.auth.oauth2_resource_demo.dto.UserBasicDTO;
import com.auth.oauth2_resource_demo.models.User;

public class UserMapper {

    public static UserBasicDTO toBasicDTO(User user) {
        return UserBasicDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    public static User fromBasicDTO(UserBasicDTO dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
    }

    public static User fromRegistrationRequest(RegistrationRequest dto) {
        return User.builder()
            .username(dto.getUsername())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .build();
    }
}