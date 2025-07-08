package com.auth.oauth2_resource_demo.dto;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private Long id;
    private String content;
    private Integer rating;
    private Date createdAt;
    private UserBasicDTO user;
}