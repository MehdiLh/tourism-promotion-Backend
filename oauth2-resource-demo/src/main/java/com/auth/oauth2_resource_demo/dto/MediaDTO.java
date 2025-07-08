package com.auth.oauth2_resource_demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaDTO {
    private Long id;
    private String type;
    private String url;
}