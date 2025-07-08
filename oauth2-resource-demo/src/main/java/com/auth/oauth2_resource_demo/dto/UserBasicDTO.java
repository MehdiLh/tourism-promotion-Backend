package com.auth.oauth2_resource_demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBasicDTO {
    private Long id;
    private String username;
    private String email;
}