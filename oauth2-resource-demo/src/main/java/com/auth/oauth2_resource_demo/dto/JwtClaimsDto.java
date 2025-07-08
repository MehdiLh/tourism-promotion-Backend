package com.auth.oauth2_resource_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtClaimsDto {
    private Integer id;
    private String roles;
    private String username;
}
