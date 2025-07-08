package com.auth.oauth2_resource_demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TouristSiteBasicDTO {
    private Long id;
    private String name;
    private String location;
}