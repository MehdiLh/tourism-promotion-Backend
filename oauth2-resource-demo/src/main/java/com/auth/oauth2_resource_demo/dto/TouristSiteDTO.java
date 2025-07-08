package com.auth.oauth2_resource_demo.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TouristSiteDTO {
    private Long id;
    private String name;
    private String description;
    private String location;
    private Double latitude;
    private Double longitude;
    private List<MediaDTO> media;
    private List<ReviewDTO> reviews;
    private double averageRating;
}